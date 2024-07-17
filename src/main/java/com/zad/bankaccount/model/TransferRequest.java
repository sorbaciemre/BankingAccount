package com.zad.bankaccount.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Created 16.07.2024
 * @Author emresorbaci
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferRequest {

    private String fromUsername;
    private String toUsername;
    private BigDecimal amount;
    private String currency;
}
