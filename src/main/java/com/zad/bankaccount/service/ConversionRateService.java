package com.zad.bankaccount.service;

import java.math.BigDecimal;

/**
 * @Created 17.07.2024
 * @Author emresorbaci
 **/
public interface ConversionRateService {

    BigDecimal getConversionRate(String fromCurrency, String toCurrency);
}
