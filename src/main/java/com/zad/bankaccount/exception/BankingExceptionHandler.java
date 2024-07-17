package com.zad.bankaccount.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Created 17.07.2024
 * @Author emresorbaci
 **/
@ControllerAdvice
public class BankingExceptionHandler {

    @ExceptionHandler(BankingNotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(BankingNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BankingInsufficientBalanceException.class)
    public ResponseEntity<String> handleInsufficientBalanceException(BankingInsufficientBalanceException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
