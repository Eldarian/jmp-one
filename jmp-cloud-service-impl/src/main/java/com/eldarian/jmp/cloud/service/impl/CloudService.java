package com.eldarian.jmp.cloud.service.impl;

import com.eldarian.jmp.dto.BankCard;
import com.eldarian.jmp.dto.Subscribtion;
import com.eldarian.jmp.dto.User;
import com.eldarian.jmp.service.api.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class CloudService implements Service {
    Map<User, List<Subscribtion>> userSubscribtions  = new HashMap<>();

    @Override
    public void subscribe(BankCard bankCard) {
        User user = bankCard.getUser();
        Subscribtion subscribtion = new Subscribtion(bankCard.getNumber(), LocalDate.now());
        userSubscribtions.computeIfAbsent(user, u -> new ArrayList<>()).add(subscribtion);
    }

    @Override
    public Optional<Subscribtion> getSubscribtionByCardNumber(String cardNumber) {
        return userSubscribtions.values().stream()
                .flatMap(Collection::parallelStream)
                .filter(subscribtion -> subscribtion.getBankCardNumber().equals(cardNumber))
                .findFirst();
    }

    @Override
    public List<User> getAllUsers() {
        return userSubscribtions.keySet().stream().collect(Collectors.toList());
    }
}
