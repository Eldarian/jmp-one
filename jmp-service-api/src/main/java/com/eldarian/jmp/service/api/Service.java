package com.eldarian.jmp.service.api;

import com.eldarian.jmp.dto.BankCard;
import com.eldarian.jmp.dto.Subscribtion;
import com.eldarian.jmp.dto.User;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

public interface Service {
    void subscribe(BankCard bankCard);
    Optional<Subscribtion> getSubscribtionByCardNumber(String cardNumber);
    List<User> getAllUsers();

    default double getAverageUsersAge() {
        return getAllUsers().stream()
                .peek(System.out::println)
                .mapToInt(user -> Period.between(user.getBirthday(), LocalDate.now()).getYears())
                .peek(System.out::println)
                .average()
                .orElse(0);
    }
}
