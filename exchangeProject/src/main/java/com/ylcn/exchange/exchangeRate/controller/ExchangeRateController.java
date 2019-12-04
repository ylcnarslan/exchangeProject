package com.ylcn.exchange.exchangeRate.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ylcn.exchange.conversion.service.CurrencyService;
import com.ylcn.exchange.exchangeRate.service.ExchangeRateService;

@Controller
public class ExchangeRateController {
	
	private static final Logger logger = LogManager.getLogger(ExchangeRateController.class);
	
	@Autowired
	ExchangeRateService exchangeRateService;
	@Autowired
	CurrencyService currencyService;
	
	
	@RequestMapping(value = "/calculate", method = RequestMethod.GET)
	public String calculate(@RequestParam(value = "source") String source,
							@RequestParam(value = "rate") String rate, Model model)
	{

		String result = exchangeRateService.getRateValue(source, rate);
		logger.info("result = " + result);
		
		model.addAttribute("rateList", exchangeRateService.getRateList());
		model.addAttribute("sourceCurrencyList", currencyService.getCurrencyList());
		model.addAttribute("targetCurrencyList", currencyService.getCurrencyList());
		model.addAttribute("resultExchange", result);
		return "index";
	}

}
