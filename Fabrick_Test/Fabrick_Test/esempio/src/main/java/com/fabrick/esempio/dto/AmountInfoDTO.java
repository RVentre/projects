package com.fabrick.esempio.dto;

import org.springframework.stereotype.Component;

import com.fabrick.esempio.model.Bonifico;
import com.fabrick.esempio.req_resp.Amount;

@Component
public class AmountInfoDTO {

	public void fillDataAmount(Amount amount, Bonifico bonifico) {
		
		float amountValue = bonifico.getDebtorAmount() !=0 ? bonifico.getDebtorAmount() : 0;
		amount.setDebtorAmount(amountValue);
		String debtorCurrency = bonifico.getDebtorCurrency() !=null ? bonifico.getDebtorCurrency() : "";
		amount.setDebtorCurrency(debtorCurrency);
		float creditorAmount = bonifico.getCreditorAmount() !=0 ? bonifico.getCreditorAmount() : 0;
		amount.setCreditorAmount(creditorAmount);
		String creditorCurrency = bonifico.getCreditorCurrency() !=null ? bonifico.getCreditorCurrency() : "";
		amount.setCreditorCurrency(creditorCurrency);
		String creditorCurrencyDate = bonifico.getCreditorCurrencyDate() !=null ? bonifico.getCreditorCurrencyDate() : "";
		amount.setCreditorCurrencyDate(creditorCurrencyDate);
		int exchangeRate = bonifico.getExchangeRate() !=0 ? bonifico.getExchangeRate() : 0;
		amount.setExchangeRate(exchangeRate);
	}
}
