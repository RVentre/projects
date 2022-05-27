package com.fabrick.esempio.dto;

import org.springframework.stereotype.Component;

import com.fabrick.esempio.model.Account;
import com.fabrick.esempio.model.Person;
import com.fabrick.esempio.req_resp.Debtor;
import com.fabrick.esempio.req_resp.InfoAccount;

@Component
public class DebtorInfoDTO {
	
	public void fillDebtorData(Debtor debtor, Person bonificoDebtor, Account accountDebtor) {
		String name = bonificoDebtor.getName() !=null ? bonificoDebtor.getName() : "";
		debtor.setName(name);
		String iban = accountDebtor.getIban() !=null ? accountDebtor.getIban() : "";
		String bicCode = accountDebtor.getBicCode() !=null ? accountDebtor.getBicCode() : "";
		InfoAccount account = new InfoAccount(iban, bicCode);
		debtor.setInfoAccount(account);
	}

}
