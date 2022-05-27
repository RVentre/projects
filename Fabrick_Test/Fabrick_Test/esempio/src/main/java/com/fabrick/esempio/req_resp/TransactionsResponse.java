package com.fabrick.esempio.req_resp;

import java.util.List;

public class TransactionsResponse {

	private String status;
	private List<InfoTransaction> transactions;
	private ErrorResponse error;
	
	public TransactionsResponse() {}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<InfoTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<InfoTransaction> transactions) {
		this.transactions = transactions;
	}

	public ErrorResponse getError() {
		return error;
	}

	public void setError(ErrorResponse error) {
		this.error = error;
	}
	
	
}
