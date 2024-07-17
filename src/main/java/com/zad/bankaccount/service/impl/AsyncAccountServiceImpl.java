package com.zad.bankaccount.service.impl;

import com.zad.bankaccount.entity.Account;
import com.zad.bankaccount.entity.User;
import com.zad.bankaccount.exception.BankingInsufficientBalanceException;
import com.zad.bankaccount.exception.BankingNotFoundException;
import com.zad.bankaccount.repository.AccountRepository;
import com.zad.bankaccount.repository.UserRepository;
import com.zad.bankaccount.service.AsyncAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;

/**
 * @Created 17.07.2024
 * @Author emresorbaci
 **/
@Service
@RequiredArgsConstructor
public class AsyncAccountServiceImpl implements AsyncAccountService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    @Override
    @Async
    public CompletableFuture<String> withdraw(String username, BigDecimal amount, String currency) {
        if (amount.compareTo(BigDecimal.ZERO) == 0)
            throw new BankingInsufficientBalanceException("Amount value should be greater than ZERO.");
        User user = userRepository.findByUsername(username).orElseThrow(() -> new BankingNotFoundException("User not found!"));
        Account account = accountRepository.findByUserAndCurrency(user, currency).orElseThrow(() -> new BankingNotFoundException("Account not found!"));
        if (account.getBalance().compareTo(amount) < 0) {
            throw new BankingInsufficientBalanceException("Insufficient balance!");
        }
        account.setBalance(account.getBalance().subtract(amount));
        accountRepository.save(account);
        return CompletableFuture.completedFuture("Withdraw transaction successful.");
    }

    @Override
    @Async
    public CompletableFuture<String> deposit(String username, BigDecimal amount, String currency) {
        if (amount.compareTo(BigDecimal.ZERO) == 0)
            throw new BankingInsufficientBalanceException("Amount value should be greater than ZERO.");
        User user = userRepository.findByUsername(username).orElseThrow(() -> new BankingNotFoundException("User not found!"));
        Account account = accountRepository.findByUserAndCurrency(user, currency).orElseThrow(() -> new BankingNotFoundException("Account not found!"));
        account.setBalance(account.getBalance().add(amount));
        accountRepository.save(account);
        return CompletableFuture.completedFuture("Deposit transaction successful.");
    }
}
