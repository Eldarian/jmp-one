package com.eldarian.jmp.cloud.service.impl;

import com.eldarian.jmp.dto.BankCard;
import com.eldarian.jmp.dto.Subscribtion;
import com.eldarian.jmp.dto.User;
import com.eldarian.jmp.service.api.Service;

import java.util.List;
import java.util.Optional;

public class CloudService implements Service {
    @Override
    public void subscribe(BankCard bankCard) {

    }

    @Override
    public Optional<Subscribtion> getSubscribtionByCardNumber(String cardNumber) {
        return Optional.empty();
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
