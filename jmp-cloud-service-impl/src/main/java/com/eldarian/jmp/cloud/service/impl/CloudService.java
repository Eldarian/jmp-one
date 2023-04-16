package com.eldarian.jmp.cloud.service.impl;

import com.eldarian.jmp.dto.BankCard;
import com.eldarian.jmp.dto.Subscription;
import com.eldarian.jmp.dto.User;
import com.eldarian.jmp.service.api.NoSubscriptionException;
import com.eldarian.jmp.service.api.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CloudService implements Service {
    Map<User, List<Subscription>> userSubscribtions  = new HashMap<>();

    @Override
    public void subscribe(BankCard bankCard) {
        User user = bankCard.getUser();
        if(Service.isPayableUser(user)) {
            Subscription subscription = new Subscription(bankCard.getNumber(), LocalDate.now());
            userSubscribtions.computeIfAbsent(user, u -> new ArrayList<>()).add(subscription);
        }
        else {
            System.out.println("User " + user + " is under 18");
        }
    }

    @Override
    public Optional<Subscription> getSubscriptionByCardNumber(String cardNumber) throws NoSubscriptionException {
        return Optional.ofNullable(userSubscribtions.values().stream()
                .flatMap(Collection::parallelStream)
                .filter(subscription -> subscription.getBankCardNumber().equals(cardNumber))
                .findFirst().orElseThrow(() -> new NoSubscriptionException("no subscribtions for such number")));
    }

    @Override
    public List<User> getAllUsers() {
        return userSubscribtions.keySet().stream().collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> subscriptionPredicate) {
        return userSubscribtions.values()
                .stream()
                .flatMap(Collection::parallelStream)
                .filter(subscriptionPredicate)
                .collect(Collectors.toList());
    }
}
