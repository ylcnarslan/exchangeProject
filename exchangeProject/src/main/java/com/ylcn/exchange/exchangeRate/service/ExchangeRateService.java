package com.ylcn.exchange.exchangeRate.service;


import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ylcn.exchange.exchangeRate.dao.ExchangeRateRepository;
import com.ylcn.exchange.exchangeRate.model.ExchangeRateModel;
import com.ylcn.exchange.exchangeRate.model.ExchangeRateServiceModel;

@Service("exchangeRateService")
public class ExchangeRateService {
	
	private static final Logger logger = LogManager.getLogger(ExchangeRateService.class);
	
	@Autowired
	ExchangeRateRepository repository;
	
	public void getExchangeRates()
	{
	    RestTemplate restTemplate = new RestTemplate();

	    ExchangeRateServiceModel result = restTemplate.getForObject(
				"http://www.apilayer.net/api/live?access_key=8e7fe5f02214467750f0b437fafbd42f&source=USD&currencies=EUR,TRY,GBP,AUD,CAD,PLN,MXN", ExchangeRateServiceModel.class);
		
		logger.info("result for USD = " + result.toString());

		for (Map.Entry<String, String> entry : result.getQuotes().entrySet()) {
			ExchangeRateModel model = new ExchangeRateModel();
	        model.setSource(result.getSource());
	        model.setRate(entry.getKey());
	        model.setValue(entry.getValue());
	         
	        ExchangeRateModel savedExchange = repository.save(model);
	        logger.info("save success = " + savedExchange);
	    }
    	 
	}
	
	public List<ExchangeRateModel> getRateList() {
		 return (List<ExchangeRateModel>) repository.findAll();
	}
	
	public String getRateValue(String source, String rate)
	{
		return repository.findBySourceAndRate(source, rate);
	}
}
