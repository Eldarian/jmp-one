package com.eldarian.jmp.service.api;

import com.eldarian.jmp.dto.BankCard;
import com.eldarian.jmp.dto.Subscription;
import com.eldarian.jmp.dto.User;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface Service {
    static boolean isPayableUser(User user) {
        return Period.between(user.getBirthday(), LocalDate.now()).getYears() >= 18;
    }
    void subscribe(BankCard bankCard);
    Optional<Subscription> getSubscriptionByCardNumber(String cardNumber) throws NoSubscriptionException;
    List<User> getAllUsers();

    List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> subscriptionPredicate);

    default double getAverageUsersAge() {
        return getAllUsers().stream()
                .peek(System.out::println)
                .mapToInt(user -> Period.between(user.getBirthday(), LocalDate.now()).getYears())
                .peek(System.out::println)
                .average()
                .orElse(0);
    }
}
