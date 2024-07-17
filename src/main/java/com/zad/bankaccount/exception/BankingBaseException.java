package com.zad.bankaccount.exception;

/**
 * @Created 17.07.2024
 * @Author emresorbaci
 **/
public abstract class BankingBaseException extends RuntimeException {
    public BankingBaseException(String message) {
        super(message);
    }

    public BankingBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BankingBaseException(Throwable cause) {
        super(cause);
    }

    public BankingBaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
