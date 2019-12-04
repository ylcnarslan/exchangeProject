package com.ylcn.exchange.conversion.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ylcn.exchange.conversion.service.ConversionCurrencyService;
import com.ylcn.exchange.conversion.service.CurrencyService;
import com.ylcn.exchange.exchangeRate.service.ExchangeRateService;

@Controller
public class ConversionCurrencyController {
	
	private static final Logger logger = LogManager.getLogger(ConversionCurrencyController.class);
	
	@Autowired
	ConversionCurrencyService conversionCurrencyService;
	@Autowired
	ExchangeRateService exchangeRateService;
	@Autowired
	CurrencyService currencyService;
	
	@RequestMapping(value = "/convert", method = RequestMethod.GET)
	public String calculate(@RequestParam(value = "amount") String amount,
							@RequestParam(value = "source") String source,
							@RequestParam(value = "target") String target, Model model)
	{

		String result = conversionCurrencyService.getConversion(source, target, amount);
		logger.info("result = " + result);
		
		model.addAttribute("rateList", exchangeRateService.getRateList());
		model.addAttribute("sourceCurrencyList", currencyService.getCurrencyList());
		model.addAttribute("targetCurrencyList", currencyService.getCurrencyList());
		model.addAttribute("resultConversion", result);
		return "index";
	}

}
