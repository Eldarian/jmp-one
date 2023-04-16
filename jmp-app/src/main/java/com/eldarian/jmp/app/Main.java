package com.eldarian.jmp.app;

import com.eldarian.jmp.bank.api.Bank;
import com.eldarian.jmp.dto.BankCard;
import com.eldarian.jmp.dto.BankCardType;
import com.eldarian.jmp.dto.User;
import com.eldarian.jmp.service.api.Service;

import java.time.LocalDate;
import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {

        ServiceLoader<Bank> bankLoader = ServiceLoader.load(Bank.class);
        ServiceLoader<Service> serviceLoader = ServiceLoader.load(Service.class);

        if(bankLoader.findFirst().isPresent() && serviceLoader.findFirst().isPresent()) {
            Bank bank = bankLoader.findFirst().get();
            Service service = serviceLoader.findFirst().get();


            User user1 = new User("John", "Wick", LocalDate.of(1973, 12, 4));
            User user2 = new User("Jim", "Hockings", LocalDate.of(2009, 4, 13));
            User user3 = new User("Emilia", "Pliater", LocalDate.of(1806, 11, 13));


            BankCard card1 = bank.createBankCard(user1, BankCardType.DEBIT);
            BankCard card2 = bank.createBankCard(user2, BankCardType.CREDIT);
            BankCard card3 = bank.createBankCard(user1, BankCardType.CREDIT);
            BankCard card4 = bank.createBankCard(user3, BankCardType.DEBIT);

            service.subscribe(card1);
            service.subscribe(card2);
            service.subscribe(card3);
            service.subscribe(card4);

            System.out.println(card1.toString());
            System.out.println(service.getAllUsers());
            System.out.println(service.getAverageUsersAge());
            System.out.println(service.getAllSubscriptionsByCondition(
                    subscription ->
                            subscription.getStartDate().isAfter(LocalDate.of(2020, 1, 1))));

        } else {
            System.out.println("one of ServiceLoaders is empty");
        }
    }
}