package com.eldarian.jmp.dto;

import java.util.Random;

public abstract class BankCard {
    private String number;
    private User user;

    public BankCard(User user) {
        this.user = user;
        number = String.valueOf(new Random().nextInt());
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "BankCard{" +
                "number='" + number + '\'' +
                ", user=" + user +
                '}';
    }
}
