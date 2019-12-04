package com.ylcn.exchange.exchangeRate.model;

import java.util.Map;

public class ExchangeRateServiceModel {

    private String source;
    private Map<String,String> quotes;

    public ExchangeRateServiceModel() { }

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Map<String, String> getQuotes() {
		return quotes;
	}

	public void setQuotes(Map<String, String> quotes) {
		this.quotes = quotes;
	}

	@Override
	public String toString() {
		return "ExchangeRateServiceModel [source=" + source + ", quotes=" + quotes + "]";
	}
	
}
