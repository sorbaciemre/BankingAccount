package com.zad.bankaccount.service;

import java.math.BigDecimal;

/**
 * @Created 16.07.2024
 * @Author emresorbaci
 **/
public interface AccountService {

    void transfer(String fromUsername, String toUsername, BigDecimal amount, String currency);

    void convert(String username, BigDecimal amount, String fromCurrency, String toCurrency);
}
