package com.fabrick.esempio.dto;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fabrick.esempio.model.Transaction;
import com.fabrick.esempio.req_resp.InfoTransaction;
import com.fabrick.esempio.req_resp.Type;

@Component
public class TransactionInfoDTO {

	public void fillTransactions(List<InfoTransaction> transactionsResponse, List<Transaction> transactions) {
		transactions.forEach(transaction -> {
			InfoTransaction infoTransaction = new InfoTransaction();
			transactionsResponse.add(fillTransactionResponse(infoTransaction, transaction));
		});
	}
	
	public InfoTransaction fillTransactionResponse(InfoTransaction transactionResponse, Transaction transaction) {
		String accountingDate = transaction.getAccountingDate()!=null ? transaction.getAccountingDate() : "";
		transactionResponse.setAccountingDate(accountingDate);
		float amount = transaction.getAmount() !=null ? transactionResponse.getAmount(): 0;
		transactionResponse.setAmount(amount);
		String currency = transaction.getCurrency()!=null ? transaction.getCurrency(): "";
		transactionResponse.setCurrency(currency);
		String transactionId = transaction.getTransactionId()!=null ? transaction.getTransactionId() : "";
		transactionResponse.setTransactionId(transactionId);
		String operationId = transaction.getOperationId()!= null ? transaction.getOperationId() : "";
		transactionResponse.setOperationId(operationId);
		Date valueDate = transaction.getValueDate()!=null ? transaction.getValueDate() : null;
		transactionResponse.setValueDate(valueDate.toString());
		String description = transaction.getDescription()!=null ? transaction.getDescription() : "";
		transactionResponse.setDescription(description);
		String value = transaction.getValue()!=null ? transaction.getValue() :"";
		String enumeration = transaction.getEnumeration()!=null ? transaction.getEnumeration() : "";
		Type type = new Type(value, enumeration);
		transactionResponse.setType(type);
		return transactionResponse;
	}
}
