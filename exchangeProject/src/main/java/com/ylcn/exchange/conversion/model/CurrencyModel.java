package com.ylcn.exchange.conversion.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "CURRENCY")
@Entity
public class CurrencyModel {

	@Id
    @GeneratedValue
    private int id;
    private String currency;

    public CurrencyModel() { }
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "CurrencyModel [currency=" + currency + "]";
	}
	
}
