package com.eldarian.jmp.service.api;

import com.eldarian.jmp.dto.BankCard;
import com.eldarian.jmp.dto.Subscribtion;
import com.eldarian.jmp.dto.User;

import java.util.List;
import java.util.Optional;

public interface Service {
    void subscribe(BankCard bankCard);
    Optional<Subscribtion> getSubscribtionByCardNumber(String cardNumber);
    List<User> getAllUsers();
}
