package com.fabrick.esempio.dto;

import org.springframework.stereotype.Component;

import com.fabrick.esempio.model.Account;
import com.fabrick.esempio.req_resp.AccountResponse;

@Component
public class AccountInfoDTO {

	public void fillAccountRespFromAccount(AccountResponse accountResp, Account account) {
		accountResp.setAccountId(account.getAccountId());
		accountResp.setAbiCode(account.getAbiCode());
		accountResp.setAccount(account.getAccount());
		accountResp.setActivatedDate(account.getActivatedDate());
		accountResp.setAlias(account.getAlias());
		accountResp.setCabCode(account.getCabCode());
		accountResp.setCountryCode(account.getCountryCode());
		accountResp.setCurrency(account.getCurrency());
		accountResp.setHolderName(account.getHolderName());
		accountResp.setIban(account.getIban());
		accountResp.setInternationalCin(account.getInternationalCin());
		accountResp.setProductName(account.getProductName());
	}
}
