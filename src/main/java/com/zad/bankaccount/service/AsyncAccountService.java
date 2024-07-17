package com.zad.bankaccount.service;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;

/**
 * @Created 17.07.2024
 * @Author emresorbaci
 **/
public interface AsyncAccountService {

    CompletableFuture<String> withdraw(String username, BigDecimal amount, String currency);

    CompletableFuture<String> deposit(String username, BigDecimal amount, String currency);


}
