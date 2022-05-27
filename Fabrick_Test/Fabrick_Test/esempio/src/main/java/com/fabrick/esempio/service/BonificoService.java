package com.fabrick.esempio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fabrick.esempio.model.Bonifico;
import com.fabrick.esempio.repository.BonificoRepository;
import com.fabrick.esempio.req_resp.BonificoRequest;


@Component
public class BonificoService {
	
	
	@Autowired 
	private BonificoRepository bonificoRepository;

	public void createBonifico(BonificoRequest requestBonifico, Bonifico newBonifico) {
		
		
		newBonifico.setMoneyTransferId(null);
		newBonifico.setStatus("OK");
		newBonifico.setDirection(null);
		newBonifico.setCro(null);
		String uri = requestBonifico.getUri() != null ? requestBonifico.getUri() : "";
		newBonifico.setUri(uri);
		newBonifico.setTrn(null);
		String description = requestBonifico.getDescription() != null ? requestBonifico.getDescription() : "";
		newBonifico.setDescription(description);
		String executionDate = requestBonifico.getExecutionDate() != null ? requestBonifico.getExecutionDate() : "";
		newBonifico.setCreatedDateTime(executionDate);
		newBonifico.setAccountedDatetime(null);
		newBonifico.setDebtorValueDate(null);
		newBonifico.setCreditorValueDate(null);
		float amount = requestBonifico.getAmount() != 0 ? requestBonifico.getAmount() : 0;
		newBonifico.setDebtorAmount(amount);
		String currency = requestBonifico.getCurrency() != null ? requestBonifico.getCurrency() : "";
		newBonifico.setDebtorCurrency(currency);
		newBonifico.setCreditorAmount(amount);
		newBonifico.setCreditorCurrency(currency);
		newBonifico.setCreditorCurrencyDate(null);
		newBonifico.setExchangeRate(0);
		boolean urgent = requestBonifico.isUrgent() ? true : false;
		newBonifico.setUrgent(urgent);
		boolean istant = requestBonifico.isInstant() ? true : false;
		newBonifico.setInstant(istant);
		String feeType = requestBonifico.getFeeType() != null ? requestBonifico.getFeeType() : "";
		newBonifico.setFeeType(feeType);
		String feeAccountId = requestBonifico.getFeeAccountId() != null ? requestBonifico.getFeeAccountId() : "";
		newBonifico.setFeeAccountId(feeAccountId);
		newBonifico.setHasTaxRelief(false);
		
		bonificoRepository.save(newBonifico);

	}
}
