package com.ylcn.exchange.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ylcn.exchange.exchangeRate.service.ExchangeRateService;

@Component
public class Initializer implements CommandLineRunner {

	@Autowired
	ExchangeRateService exchangeRateService;
	
	@Override
	public void run(String... args) throws Exception {
		exchangeRateService.getExchangeRates();
	}

}
