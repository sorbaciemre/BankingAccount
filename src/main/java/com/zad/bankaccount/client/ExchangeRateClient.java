package com.zad.bankaccount.client;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Created 16.07.2024
 * @Author emresorbaci
 **/
@FeignClient(name = "exchangeRateClient", url = "https://v6.exchangerate-api.com/v6/da431b7d43a3218185efff1c/latest")
public interface ExchangeRateClient {

    @GetMapping("/{currency}")
    ObjectNode getExchangeRates(@PathVariable String currency);
}
