package com.fabrick.esempio.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fabrick.esempio.dto.AccountInfoDTO;
import com.fabrick.esempio.dto.AmountInfoDTO;
import com.fabrick.esempio.dto.BonificoInfoDTO;
import com.fabrick.esempio.dto.CreditorInfoDTO;
import com.fabrick.esempio.dto.DebtorInfoDTO;
import com.fabrick.esempio.dto.FeeInfoDTO;
import com.fabrick.esempio.dto.TransactionInfoDTO;
import com.fabrick.esempio.model.Account;
import com.fabrick.esempio.model.Address;
import com.fabrick.esempio.model.Bonifico;
import com.fabrick.esempio.model.Fee;
import com.fabrick.esempio.model.Person;
import com.fabrick.esempio.model.Transaction;
import com.fabrick.esempio.repository.AccountRepository;
import com.fabrick.esempio.repository.AddressRepository;
import com.fabrick.esempio.repository.BonificoRepository;
import com.fabrick.esempio.repository.FeeRepository;
import com.fabrick.esempio.repository.PersonRepository;
import com.fabrick.esempio.repository.TransactionRepository;
import com.fabrick.esempio.req_resp.AccountResponse;
import com.fabrick.esempio.req_resp.Amount;
import com.fabrick.esempio.req_resp.BonificoFinalResp;
import com.fabrick.esempio.req_resp.BonificoRequest;
import com.fabrick.esempio.req_resp.BonificoResponse;
import com.fabrick.esempio.req_resp.Creditor;
import com.fabrick.esempio.req_resp.Debtor;
import com.fabrick.esempio.req_resp.ErrorResponse;
import com.fabrick.esempio.req_resp.InfoFee;
import com.fabrick.esempio.req_resp.InfoTransaction;
import com.fabrick.esempio.req_resp.TransactionsResponse;
import com.fabrick.esempio.service.BancaService;
import com.fabrick.esempio.service.BonificoService;
import com.fabrick.esempio.service.CheckDataService;
import com.fabrick.esempio.service.TransactionService;

@RestController
public class BancaController {
	
	private BancaService bancaService = new BancaService();
	
	@Autowired
	private AccountInfoDTO accountInfoDTO;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private CheckDataService checkDataService;
	
	@Autowired 
	private TransactionRepository transactionRepository;
	
	@Autowired
	private TransactionInfoDTO transactionInfoDTO;
	
	@Autowired
	private  BonificoService bonificoService;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired 
	private AddressRepository addressRepository;
	
	@Autowired 
	private FeeRepository feeRepository;
	
	@Autowired
	private BonificoRepository bonificoRepository;
	
	@Autowired
	private CreditorInfoDTO creditorInfoDTO;
	
	@Autowired
	private DebtorInfoDTO debtorInfoDTO;
	
	@Autowired
	private AmountInfoDTO amountInfoDTO;
	
	@Autowired
	private FeeInfoDTO feeInfoDTO;
	
	@Autowired
	private BonificoInfoDTO bonificoInfoDTO;
	
	@Autowired
	private TransactionService transactionService;
	
	
	@GetMapping("/api/gbs/banking/v4.0/accounts")
	public List<AccountResponse> getAccounts() {
		
		ArrayList<AccountResponse> listaAccountResp = new ArrayList<>();
		
		Iterable<Account> listaAccount = accountRepository.findAll();
		listaAccount.forEach(account -> {
			AccountResponse accountResp = new AccountResponse();
			accountInfoDTO.fillAccountRespFromAccount(accountResp, account);
			listaAccountResp.add(accountResp);
		});
		return listaAccountResp;
	}


	
	@PostMapping("/api/gbs/banking/v4.0/accounts/{id}/payments/money-transfers")
	public BonificoFinalResp generateBonifico(@PathVariable Long id, @RequestBody BonificoRequest bonificoRequest) {
		
		Account accountDebtor = new Account();
		Person debtor = new Person();
		Person creditor = new Person();
		Account accountCreditor = new Account();
		Address addressCreditor = new Address();
		BonificoResponse bonificoResponse = new BonificoResponse();
		Debtor debtorResponse = new Debtor();
		Creditor creditorResponse = new Creditor();
		Amount amount = new Amount();
		List<InfoFee> infoFees = new ArrayList<>();
		Iterable<Fee> fees = null;
		ErrorResponse error = new ErrorResponse();
		
		BonificoFinalResp finalResp = new BonificoFinalResp();
		
		if(!checkDataService.checkCampiRequired(bonificoRequest)) {
			finalResp.setStatus("KO");
			error = new ErrorResponse();
			error.setCode("0000");
			error.setMessage("Mancanza di campi");
			error.setStatus("KO");
			finalResp.setBonificoResponse(null);
			finalResp.setError(error);
			return finalResp;
		}
		
		try {
			accountDebtor = accountRepository.findById(id).orElseThrow();
			debtor = accountDebtor.getIntestatario();
			String creditorName = bonificoRequest.getCreditor().getName();
			creditor = personRepository.findByName(creditorName); //ritorna null se non lo trova
			String iban = bonificoRequest.getCreditor().getAccount().getAccountCode();
			accountCreditor = accountRepository.findByIban(iban); //ritorna null se non lo trova
			String addressName = bonificoRequest.getCreditor().getAddress().getAddress();
			addressCreditor = addressRepository.findByAddress(addressName);
			fees = feeRepository.findAll();
		}
		catch(Exception e) {
			finalResp.setStatus("KO");
			error = new ErrorResponse();
			error.setCode("0001");
			error.setMessage("DB error -> "+e.getMessage());
			error.setStatus("KO");
			finalResp.setBonificoResponse(null);
			finalResp.setError(error);
			return finalResp;
		}
		finally {
			
		}
		if(!checkDataService.checkBonifico(accountDebtor, debtor, accountCreditor, addressCreditor, creditor)) {
			finalResp.setStatus("KO");
			error = new ErrorResponse();
			error.setCode("0002");
			error.setMessage("Bonifico non corretto");
			error.setStatus("KO");
			finalResp.setBonificoResponse(null);
			finalResp.setError(error);
			return finalResp;
		}
		else {
			Bonifico newBonifico = new Bonifico();
			
			newBonifico.setCreditorAccount(accountCreditor);
			newBonifico.setDebtorAccount(accountDebtor);
			
			bonificoService.createBonifico(bonificoRequest, newBonifico);
			
			try {
				transactionService.createTransaction(newBonifico);
				debtorInfoDTO.fillDebtorData(debtorResponse, debtor, accountDebtor);
				creditorInfoDTO.fillCreditorData(creditorResponse, creditor, accountCreditor, addressCreditor);
				amountInfoDTO.fillDataAmount(amount, newBonifico);
				feeInfoDTO.fillDataFees(infoFees, fees);
				bonificoInfoDTO.fillBonificoData(bonificoResponse, newBonifico, creditorResponse, debtorResponse, amount, infoFees);	
				finalResp.setStatus("OK");
				finalResp.setError(null);
			}
			catch(Exception e) {
				finalResp.setStatus("KO");
				error = new ErrorResponse();
				error.setCode("0007");
				error.setMessage("Bonifico creato e poi eliminato, errore nel DTO");
				error.setStatus("KO");
				finalResp.setBonificoResponse(null);
				finalResp.setError(error);
				bonificoRepository.delete(newBonifico);
				return finalResp;
			}
			finalResp.setStatus("OK");
			finalResp.setBonificoResponse(bonificoResponse);
			finalResp.setError(error);
			
			return finalResp;
		}
	}
	

	@GetMapping("/api/gbs/banking/v4.0/accounts/{id}/transactions")
	public TransactionsResponse getTransactionList(@PathVariable Long id, @RequestParam String fromAccountingDate, @RequestParam String toAccountingDate) {
		
		TransactionsResponse resp = new TransactionsResponse();
		
		List<Transaction> transactions = new ArrayList<Transaction>();
		Account account = new Account();
		List<InfoTransaction> transactionsResponse = new ArrayList<>();
		ErrorResponse error = new ErrorResponse();
		
		try {
			Date date1 = bancaService.convertDate(fromAccountingDate);
			Date date2 = bancaService.convertDate(toAccountingDate);
			if(checkDataService.checkDate(date1, date2)) {
				account = accountRepository.findById(id).orElseThrow();
				transactions = transactionRepository.findAllByAccountAndValueDateBetween(account, date1, date2);
				transactionInfoDTO.fillTransactions(transactionsResponse, transactions);
			}
		}
		catch(Exception e) {
			resp.setStatus("KO");
			error = new ErrorResponse();
			error.setCode("0005");
			error.setMessage("Account or date problem -> "+e.getMessage());
			error.setStatus("KO");
			resp.setTransactions(null);
			resp.setError(error);
			return resp;
		}
		finally {
			
		}
		resp.setStatus("OK");
		resp.setTransactions(transactionsResponse);
		resp.setError(null);
		return resp;
	}
	
}
