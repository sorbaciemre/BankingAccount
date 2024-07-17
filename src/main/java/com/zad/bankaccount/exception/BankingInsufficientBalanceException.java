package com.zad.bankaccount.exception;

/**
 * @Created 17.07.2024
 * @Author emresorbaci
 **/
public class BankingInsufficientBalanceException extends BankingBaseException {
    public BankingInsufficientBalanceException(String message) {
        super(message);
    }

    public BankingInsufficientBalanceException(String message, Throwable cause) {
        super(message, cause);
    }

    public BankingInsufficientBalanceException(Throwable cause) {
        super(cause);
    }

    public BankingInsufficientBalanceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
