package com.eldarian.jmp.cloud.bank.impl;

import com.eldarian.jmp.bank.api.Bank;
import com.eldarian.jmp.dto.*;

public class CloudBankImpl implements Bank {
    @Override
    public BankCard createBankCard(User user, BankCardType bankCardType) {

        // TODO: 10/04/2023 Replace with java8 style code
        switch (bankCardType) {
            case CREDIT: return new CreditBankCard(user);
            case DEBIT: return new DebitBankCard(user);
            default: return null;
        }
    }
}
