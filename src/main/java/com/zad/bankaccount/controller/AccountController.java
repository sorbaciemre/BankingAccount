package com.zad.bankaccount.controller;

import com.zad.bankaccount.model.ConvertRequest;
import com.zad.bankaccount.model.DepositRequest;
import com.zad.bankaccount.model.TransferRequest;
import com.zad.bankaccount.model.WithdrawRequest;
import com.zad.bankaccount.service.AccountService;
import com.zad.bankaccount.service.AsyncAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

/**
 * @Created 16.07.2024
 * @Author emresorbaci
 **/

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;
    private final AsyncAccountService asyncAccountService;

    @PostMapping("/deposit")
    public CompletableFuture<String> deposit(@RequestBody DepositRequest request) {
        return asyncAccountService.deposit(request.getUsername(), request.getAmount(), request.getCurrency());
    }

    @PostMapping("/withdraw")
    public CompletableFuture<String> withdraw(@RequestBody WithdrawRequest request) {
        return asyncAccountService.withdraw(request.getUsername(), request.getAmount(), request.getCurrency());
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestBody TransferRequest request) {
        accountService.transfer(request.getFromUsername(), request.getToUsername(), request.getAmount(), request.getCurrency());
        return ResponseEntity.ok("Transfer transaction successful.");
    }

    @PostMapping("/convert")
    public ResponseEntity<String> convert(@RequestBody ConvertRequest request) {
        accountService.convert(request.getUsername(), request.getAmount(), request.getFromCurrency(), request.getToCurrency());
        return ResponseEntity.ok("Conversion transaction successful.");
    }

}
