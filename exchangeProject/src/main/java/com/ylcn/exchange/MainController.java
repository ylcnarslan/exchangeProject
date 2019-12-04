package com.ylcn.exchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ylcn.exchange.conversion.service.CurrencyService;
import com.ylcn.exchange.exchangeRate.service.ExchangeRateService;

@Controller
public class MainController {

	@Autowired
	ExchangeRateService exchangeRateService;
	@Autowired
	CurrencyService currencyService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String show(Model model)
	{		
		model.addAttribute("rateList", exchangeRateService.getRateList());
		model.addAttribute("sourceCurrencyList", currencyService.getCurrencyList());
		model.addAttribute("targetCurrencyList", currencyService.getCurrencyList());
		return "index";
	}

}
