package com.zad.bankaccount.service.impl;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zad.bankaccount.client.ExchangeRateClient;
import com.zad.bankaccount.service.ConversionRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Created 17.07.2024
 * @Author emresorbaci
 **/
@Service
@RequiredArgsConstructor
public class ConversionRateServiceImpl implements ConversionRateService {

    private final ExchangeRateClient exchangeRateClient;

    @Override
    @Cacheable(value = "conversionRate", key = "#fromCurrency")
    public BigDecimal getConversionRate(String fromCurrency, String toCurrency) {
        ObjectNode exchangeRates = exchangeRateClient.getExchangeRates(fromCurrency);
        return new BigDecimal(exchangeRates.get("conversion_rates").get(toCurrency).asText());
    }
}
