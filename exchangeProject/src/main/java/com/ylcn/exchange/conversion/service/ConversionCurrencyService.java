package com.ylcn.exchange.conversion.service;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ylcn.exchange.conversion.dao.ConversionCurrencyRepository;
import com.ylcn.exchange.conversion.model.ConversionCurrencyServiceModel;

@Service("conversionCurrencyService")
public class ConversionCurrencyService {
	
	private static final Logger logger = LogManager.getLogger(ConversionCurrencyService.class);
	
	@Autowired
	ConversionCurrencyRepository conversionCurrencyRepository;
	
	public String getConversion(String source, String target, String amount)
	{
	    RestTemplate restTemplate = new RestTemplate();

	    ConversionCurrencyServiceModel result = restTemplate.getForObject(
				"https://www.amdoren.com/api/currency.php?api_key=MKaw69guiVFkVdUenGrfL2aDxNvVmd&from=" + source + "&to=" + target + "&amount=" + amount, ConversionCurrencyServiceModel.class);
		
		logger.info("conversion result from " + source + " to " + target + " for " + amount + " = " + result);

    	return result.getAmount(); 
	}
}
