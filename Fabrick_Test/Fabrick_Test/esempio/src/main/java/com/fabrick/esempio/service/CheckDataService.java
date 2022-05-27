package com.fabrick.esempio.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fabrick.esempio.model.Account;
import com.fabrick.esempio.model.Address;
import com.fabrick.esempio.model.Person;
import com.fabrick.esempio.req_resp.BonificoRequest;

@Component
public class CheckDataService {
	
	@Autowired
	private AccountService accountService;

	public boolean checkDate(Date date1, Date date2) throws Exception {
		boolean resp = false;
		if(date1!=null && date2!=null && date2.after(date1)) {
			resp = true;
		}
		return resp;
	}
	
	public boolean checkBonifico(Account accountDebtor, Person debtor, Account accountCreditor, Address addressCreditor, Person creditor) {
		boolean resp = false;
		if(accountService.checkAccount(accountCreditor) && accountService.checkAccount(accountDebtor)) {
			if(creditor!=null && addressCreditor!=null && accountCreditor!=null) {
				if(accountCreditor.getIntestatario().equals(creditor) && addressCreditor.equals(creditor.getAddress()) ) {
					resp =true;
				}
			}
		}
		return resp;
	}

	public boolean checkCampiRequired(BonificoRequest bonificoRequest) {
		boolean resp = true;
		
		//taxRelief.beneficiaryType
		if(isEmptyOrNull(bonificoRequest.getCreditor().toString()) ||
				isEmptyOrNull(bonificoRequest.getCreditor().getName()) ||
				isEmptyOrNull(bonificoRequest.getCreditor().getAccount().toString())||
				isEmptyOrNull(bonificoRequest.getCreditor().getAccount().getAccountCode())||
				isEmptyOrNull(bonificoRequest.getDescription())||
				isEmptyOrNull(String.valueOf(bonificoRequest.getAmount()))||
				isEmptyOrNull(bonificoRequest.getCurrency())||
				isEmptyOrNull(bonificoRequest.getTaxRelief().toString())||
				isEmptyOrNull(String.valueOf(bonificoRequest.getTaxRelief().isCondoUpgrade()))||
				isEmptyOrNull(bonificoRequest.getTaxRelief().getCreditorFiscalCode())||
				isEmptyOrNull(bonificoRequest.getTaxRelief().getNaturalPersonBeneficiary().getFiscalCode1())||
				isEmptyOrNull(bonificoRequest.getTaxRelief().getLegalPersonBeneficiary().getFiscalCode())) {
			resp = false;
		}
		
		return resp;
	}
	
	public boolean isEmptyOrNull(String campo) {
		if(campo==null ||campo.isEmpty()) {
			return true;
		}
		return false;
	}
	
}
