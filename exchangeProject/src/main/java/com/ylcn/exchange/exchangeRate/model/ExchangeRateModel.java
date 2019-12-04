package com.ylcn.exchange.exchangeRate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "EXCHANGE_RATE")
@Entity
public class ExchangeRateModel {

	@Id
    @GeneratedValue
    private int id;
	private String source;
	private String rate;
	private String value;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "ExchangeRateModel [id=" + id + ", source=" + source + ", rate=" + rate + ", value=" + value + "]";
	}
	
}
