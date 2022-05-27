package com.fabrick.esempio;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fabrick.esempio.controller.BancaController;
import com.fabrick.esempio.model.Account;
import com.fabrick.esempio.repository.AccountRepository;
import com.fabrick.esempio.req_resp.AccountResponse;


public class GetAccountTest {
	
	private BancaController bancaController= new BancaController();
	
	@Autowired
	private AccountRepository accountRepository;

	@Test
	public void getAccount() {
		
		Account account1 = new Account();
		account1.setIban("IT22D3706978430115706240270");
		account1.setAccountId("14930637");
		account1.setAbiCode("37069");
		account1.setCabCode("78430");
		account1.setCountryCode("IT");
		account1.setInternationalCin("22");
		account1.setAccount("115706240270");
		account1.setAlias("Company main account");
		account1.setProductName("Generic company cash account");
		account1.setHolderName("ACME Inc.");
		account1.setActivatedDate("2008-12-25");
		account1.setCurrency("EUR");
		accountRepository.save(account1);
		
		List<AccountResponse> accounts = bancaController.getAccounts();
		
		assertThat(accounts.size()).isEqualTo(1);
	}
}
