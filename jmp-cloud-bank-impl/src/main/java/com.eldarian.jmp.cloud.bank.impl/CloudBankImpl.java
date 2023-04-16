package com.eldarian.jmp.cloud.bank.impl;

import com.eldarian.jmp.bank.api.Bank;
import com.eldarian.jmp.dto.*;

public class CloudBankImpl implements Bank {
    @Override
    public BankCard createBankCard(User user, BankCardType bankCardType) {
        return switch (bankCardType) {

            case CREDIT -> { BankCardFactory factory = CreditBankCard::new;
                            yield factory.create(user);
            }
            case DEBIT -> { BankCardFactory factory = DebitBankCard::new;
                    yield factory.create(user);}
        };
    }

    @FunctionalInterface
    interface BankCardFactory {
        BankCard create(User user);
    }
}
