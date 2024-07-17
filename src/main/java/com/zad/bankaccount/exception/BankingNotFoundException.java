package com.zad.bankaccount.exception;

/**
 * @Created 17.07.2024
 * @Author emresorbaci
 **/
public class BankingNotFoundException extends BankingBaseException {
    public BankingNotFoundException(String message) {
        super(message);
    }

    public BankingNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BankingNotFoundException(Throwable cause) {
        super(cause);
    }

    public BankingNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
