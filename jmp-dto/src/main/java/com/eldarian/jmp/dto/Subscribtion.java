package com.eldarian.jmp.dto;

import java.time.LocalDate;

public class Subscribtion {
    private String bankCardNumber;
    private LocalDate startDate;

    public Subscribtion(String bankCardNumber, LocalDate startDate) {
        this.bankCardNumber = bankCardNumber;
        this.startDate = startDate;
    }

    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

}
