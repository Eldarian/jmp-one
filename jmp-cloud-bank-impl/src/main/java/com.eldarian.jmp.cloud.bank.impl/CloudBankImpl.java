package com.eldarian.jmp.cloud.bank.impl;

import com.eldarian.jmp.bank.api.Bank;
import com.eldarian.jmp.dto.*;

public class CloudBankImpl implements Bank {
    @Override
    public BankCard createBankCard(User user, BankCardType bankCardType) {
        switch (bankCardType) {
            case CREDIT: return new CreditBankCard();
            case DEBIT: return new DebitBankCard();
            default: return null;
        }
    }
}
