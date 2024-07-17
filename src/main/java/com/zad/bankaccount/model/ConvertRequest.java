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
@AllArgsConstructor
@NoArgsConstructor
public class ConvertRequest {

    private String username;
    private BigDecimal amount;
    private String fromCurrency;
    private String toCurrency;
}
