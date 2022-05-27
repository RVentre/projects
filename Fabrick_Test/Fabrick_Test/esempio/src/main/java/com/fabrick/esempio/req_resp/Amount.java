package com.fabrick.esempio.req_resp;

public class Amount {

	private float debtorAmount;
	private String debtorCurrency;
	private float creditorAmount;
	private String creditorCurrency;
	private String creditorCurrencyDate;
	private int exchangeRate;
	
	
	
	
	public float getDebtorAmount() {
		return debtorAmount;
	}




	public void setDebtorAmount(float debtorAmount) {
		this.debtorAmount = debtorAmount;
	}




	public String getDebtorCurrency() {
		return debtorCurrency;
	}




	public void setDebtorCurrency(String debtorCurrency) {
		this.debtorCurrency = debtorCurrency;
	}




	public float getCreditorAmount() {
		return creditorAmount;
	}




	public void setCreditorAmount(float creditorAmount) {
		this.creditorAmount = creditorAmount;
	}




	public String getCreditorCurrency() {
		return creditorCurrency;
	}




	public void setCreditorCurrency(String creditorCurrency) {
		this.creditorCurrency = creditorCurrency;
	}




	public String getCreditorCurrencyDate() {
		return creditorCurrencyDate;
	}

	public void setCreditorCurrencyDate(String creditorCurrencyDate) {
		this.creditorCurrencyDate = creditorCurrencyDate;
	}

	public int getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(int exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public Amount() {}
	
	
}
