package com.fabrick.esempio.dto;

import org.springframework.stereotype.Component;

import com.fabrick.esempio.model.Account;
import com.fabrick.esempio.model.Address;
import com.fabrick.esempio.model.Person;
import com.fabrick.esempio.req_resp.Creditor;
import com.fabrick.esempio.req_resp.InfoAccount;
import com.fabrick.esempio.req_resp.InfoAddress;

@Component
public class CreditorInfoDTO {

	public void fillCreditorData(Creditor creditor, Person bonificoCreditor, Account bonificoCreditorAccount, Address addressCreditor) {
		
		String name = bonificoCreditor.getName() !=null ? bonificoCreditor.getName() : "";
		creditor.setName(name);
		String iban = bonificoCreditorAccount.getIban() !=null ? bonificoCreditorAccount.getIban() : "";
		String bicCode = bonificoCreditorAccount.getBicCode() !=null ? bonificoCreditorAccount.getBicCode() : "";
		InfoAccount account = new InfoAccount(iban, bicCode);
		creditor.setAccount(account);
		String address = addressCreditor.getAddress() !=null ? addressCreditor.getAddress() : "";
		String city = addressCreditor.getCity() !=null ? addressCreditor.getCity() : "";
		String countryCode = addressCreditor.getCountryCode() !=null ? addressCreditor.getCountryCode() : "";
		InfoAddress infoAddress = new InfoAddress(address, city, countryCode);
		creditor.setAddress(infoAddress);
	}
}
