package com.ylcn.exchange.conversion.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylcn.exchange.conversion.dao.CurrencyRepository;
import com.ylcn.exchange.conversion.model.CurrencyModel;

@Service("currencyService")
public class CurrencyService {

	@Autowired
	CurrencyRepository currencyRepository;
	
	public Iterable<CurrencyModel> getCurrencyList()
	{
		return currencyRepository.findAll();
	}
}
