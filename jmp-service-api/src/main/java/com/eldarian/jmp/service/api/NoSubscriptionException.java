package com.eldarian.jmp.service.api;

public class NoSubscriptionException extends Exception {
    public NoSubscriptionException() {
    }

    public NoSubscriptionException(String message) {
        super(message);
    }

    public NoSubscriptionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSubscriptionException(Throwable cause) {
        super(cause);
    }

    public NoSubscriptionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
