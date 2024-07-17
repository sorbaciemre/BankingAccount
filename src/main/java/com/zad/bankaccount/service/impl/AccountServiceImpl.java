package com.zad.bankaccount.service.impl;

import com.zad.bankaccount.entity.Account;
import com.zad.bankaccount.entity.User;
import com.zad.bankaccount.exception.BankingInsufficientBalanceException;
import com.zad.bankaccount.exception.BankingNotFoundException;
import com.zad.bankaccount.repository.AccountRepository;
import com.zad.bankaccount.repository.UserRepository;
import com.zad.bankaccount.service.AccountService;
import com.zad.bankaccount.service.ConversionRateService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Created 16.07.2024
 * @Author emresorbaci
 **/
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final ConversionRateService conversionRateService;
    @Override
    @Transactional
    public void transfer(String fromUsername, String toUsername, BigDecimal amount, String currency) {
        if (amount.compareTo(BigDecimal.ZERO) == 0)
            throw new BankingInsufficientBalanceException("Amount value should be greater than ZERO.");
        User toUser = userRepository.findByUsername(toUsername).orElseThrow(() ->new BankingNotFoundException("User not found! username: " + toUsername));
        User fromUser = userRepository.findByUsername(fromUsername).orElseThrow(() ->new BankingNotFoundException("User not found! username: " + fromUsername));

        Account fromAccount = accountRepository.findByUserAndCurrency(fromUser, currency).orElseThrow(() -> new BankingNotFoundException("From Account not found!"));
        Account toAccount = accountRepository.findByUserAndCurrency(toUser, currency).orElseThrow(() -> new BankingNotFoundException("To Account not found!"));
        if (fromAccount.getBalance().compareTo(amount) < 0) {
            throw new BankingInsufficientBalanceException("Insufficient balance!");
        }
        fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
        toAccount.setBalance(toAccount.getBalance().add(amount));
        accountRepository.save(toAccount);
        accountRepository.save(fromAccount);
    }

    @Override
    @Transactional
    public void convert(String username, BigDecimal amount, String fromCurrency, String toCurrency) {
        if (amount.compareTo(BigDecimal.ZERO) == 0)
            throw new BankingInsufficientBalanceException("Amount value should be greater than ZERO.");
        User user = userRepository.findByUsername(username).orElseThrow(() -> new BankingNotFoundException("User not found!"));
        Account fromAccount = accountRepository.findByUserAndCurrency(user, fromCurrency).orElseThrow(() -> new BankingNotFoundException("Account not found!"));
        Account toAccount = accountRepository.findByUserAndCurrency(user, toCurrency).orElseThrow(() -> new BankingNotFoundException("Account not found!"));
        if (fromAccount.getBalance().compareTo(amount) < 0) {
            throw new BankingInsufficientBalanceException("Insufficient balance!");
        }
        fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
        BigDecimal conversionRate = conversionRateService.getConversionRate(fromCurrency, toCurrency);
        toAccount.setBalance(toAccount.getBalance().add(amount.multiply(conversionRate)));
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
    }
}
