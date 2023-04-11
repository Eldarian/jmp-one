package com.eldarian.jmp.app;

import com.eldarian.jmp.bank.api.Bank;
import com.eldarian.jmp.cloud.bank.impl.CloudBankImpl;
import com.eldarian.jmp.dto.BankCard;
import com.eldarian.jmp.dto.BankCardType;
import com.eldarian.jmp.dto.User;

import java.time.LocalDate;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Bank cloudBank = new CloudBankImpl();
        User user1 = new User("John", "Wick", LocalDate.of(1973, 12, 4));
        BankCard card1 = cloudBank.createBankCard(user1, BankCardType.DEBIT);
        System.out.println(card1.toString());


    }
}