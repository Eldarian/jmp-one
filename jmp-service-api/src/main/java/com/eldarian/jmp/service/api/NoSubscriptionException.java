package com.eldarian.jmp.service.api;

public class NoSubscriptionException extends Exception {
    public NoSubscriptionException() {
    }

    public NoSubscriptionException(String message) {
        super(message);
    }
}
