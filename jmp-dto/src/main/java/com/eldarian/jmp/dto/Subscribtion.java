package com.eldarian.jmp.dto;

import java.time.LocalDate;

public class Subscribtion {
    private String bankCard;
    private LocalDate startDate;
    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

}
