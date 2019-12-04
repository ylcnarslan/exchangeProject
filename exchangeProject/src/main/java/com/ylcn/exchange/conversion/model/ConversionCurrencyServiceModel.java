package com.ylcn.exchange.conversion.model;

public class ConversionCurrencyServiceModel {

    private String error;
    private String errorMessage;
    private String amount;

    public ConversionCurrencyServiceModel() { }

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "ConversionServiceModel [error=" + error + ", errorMessage=" + errorMessage + ", amount=" + amount + "]";
	}
	
}
