package com.fabrick.esempio.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Transaction {

	@Id
	@GeneratedValue
	private UUID id;
	
	@Column(name = "TRANSACTION_ID")
	private String transactionId;
	
	@Column(name = "OPERATION_ID")
	private String operationId;
	
	@Column(name = "ACCOUNTING_DATE")
	private String accountingDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "VALUE_DATE")
	private Date valueDate;
	
	@Column(name = "ENUMERATION")
	private String enumeration;
	
	@Column(name = "VALUE")
	private String value;
	
	@Column(name = "AMOUNT")
	private String amount;
	
	@Column(name = "CURRENCY")
	private String currency;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "ACCOUNT")
	private Account account;
	
	@OneToOne
	@JoinColumn(name = "DEBTOR")
	private Person debtor;
	
	@OneToOne
	@JoinColumn(name = "CREDITOR")
	private Person creditor;
	
	
	public Transaction() {}
	

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Person getDebtor() {
		return debtor;
	}

	public void setDebtor(Person debtor) {
		this.debtor = debtor;
	}

	public Person getCreditor() {
		return creditor;
	}

	public void setCreditor(Person creditor) {
		this.creditor = creditor;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getOperationId() {
		return operationId;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	public String getAccountingDate() {
		return accountingDate;
	}

	public void setAccountingDate(String accountingDate) {
		this.accountingDate = accountingDate;
	}

	public Date getValueDate() {
		return valueDate;
	}

	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}

	public String getEnumeration() {
		return enumeration;
	}

	public void setEnumeration(String enumeration) {
		this.enumeration = enumeration;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
