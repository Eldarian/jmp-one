package com.eldarian.jmp.cloud.service.impl;

import com.eldarian.jmp.dto.BankCard;
import com.eldarian.jmp.dto.CreditBankCard;
import com.eldarian.jmp.dto.User;

import java.time.LocalDate;

import static org.testng.Assert.*;

public class CloudServiceTest {

    @org.testng.annotations.Test
    public void testSubscribe() {
        BankCard card = new CreditBankCard(new User("Jack", "Black", LocalDate.of(1985,10,15)));
    }
}