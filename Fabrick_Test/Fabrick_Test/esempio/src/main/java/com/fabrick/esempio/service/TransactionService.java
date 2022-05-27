package com.fabrick.esempio.service;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fabrick.esempio.model.Bonifico;
import com.fabrick.esempio.model.Transaction;
import com.fabrick.esempio.repository.TransactionRepository;

@Component
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private BancaService bancaService;
	
	public void createTransaction(Bonifico bonifico) throws ParseException {
		
		Transaction transaction = new Transaction();
		transaction.setTransactionId("12345");
		transaction.setOperationId("BONIFICO");
		transaction.setAccountingDate(bonifico.getCreatedDateTime());
		transaction.setValueDate(bancaService.convertDate(bonifico.getCreatedDateTime()));
		transaction.setAmount(String.valueOf(bonifico.getDebtorAmount()));
		transaction.setCurrency(bonifico.getDebtorCurrency());
		transaction.setDescription(bonifico.getDescription());
		transaction.setValue("BONIFICO");
		transaction.setEnumeration("BONIFICO");
		transaction.setDebtor(bonifico.getDebtorAccount().getIntestatario());
		transaction.setCreditor(bonifico.getCreditorAccount().getIntestatario());
		transaction.setAccount(bonifico.getDebtorAccount());
		
		transactionRepository.save(transaction);		
	}

}
