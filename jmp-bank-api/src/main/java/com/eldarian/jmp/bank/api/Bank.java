package com.eldarian.jmp.bank.api;

import com.eldarian.jmp.dto.BankCard;
import com.eldarian.jmp.dto.BankCardType;
import com.eldarian.jmp.dto.User;

public interface Bank {
    BankCard createBankCard(User user, BankCardType bankCardType);
}
