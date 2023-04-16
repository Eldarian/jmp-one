package com.eldarian.jmp.app;

import com.eldarian.jmp.bank.api.Bank;
import com.eldarian.jmp.cloud.bank.impl.CloudBankImpl;
import com.eldarian.jmp.cloud.service.impl.CloudService;
import com.eldarian.jmp.dto.BankCard;
import com.eldarian.jmp.dto.BankCardType;
import com.eldarian.jmp.dto.User;
import com.eldarian.jmp.service.api.Service;

import java.time.LocalDate;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Bank cloudBank = new CloudBankImpl();
        Service service = new CloudService();

        User user1 = new User("John", "Wick", LocalDate.of(1973, 12, 4));
        User user2 = new User("Jim", "Hockings", LocalDate.of(2009, 4, 13));
        User user3 = new User("Emilia", "Pliater", LocalDate.of(1806, 11, 13));


        BankCard card1 = cloudBank.createBankCard(user1, BankCardType.DEBIT);
        BankCard card2 = cloudBank.createBankCard(user2, BankCardType.CREDIT);
        BankCard card3 = cloudBank.createBankCard(user1, BankCardType.CREDIT);
        BankCard card4 = cloudBank.createBankCard(user3, BankCardType.DEBIT);

        service.subscribe(card1);
        service.subscribe(card2);
        service.subscribe(card3);
        service.subscribe(card4);

        System.out.println(card1.toString());
        System.out.println(service.getAllUsers());
        System.out.println(service.getAverageUsersAge());


    }
}