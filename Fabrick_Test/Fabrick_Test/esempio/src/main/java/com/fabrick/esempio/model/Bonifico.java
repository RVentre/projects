package com.fabrick.esempio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Bonifico {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CREDITOR_ACCOUNT")
	private Account creditorAccount;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="DEBTOR_ACCOUNT")
	private Account debtorAccount;
	
	@Column(name="MONEY_TRANSFER_ID")
	private String moneyTransferId;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="DIRECTION")
	private String direction;
	
	@Column(name="CRO")
	private String cro;
	
	@Column(name="URI")
	private String uri;
	
	@Column(name="TRN")
	private String trn;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="CREATED_DATE_TIME")
	private String createdDateTime;
	
	@Column(name="ACCOUNT_DATE_TIME")
	private String accountedDatetime;
	
	@Column(name="DEBTOR_VALUE_DATE")
	private String debtorValueDate;
	
	@Column(name="CREDITOR_VALUE_DATE")
	private String creditorValueDate;
	
	@Column(name="DEBTOR_AMOUNT")
	private float debtorAmount;
	
	@Column(name="DEBTOR_CURRENCY")
	private String debtorCurrency;
	
	@Column(name="CREDITOR_AMOUNT")
	private float creditorAmount;
	
	@Column(name="CREDITOR_CURRENCY")
	private String creditorCurrency;
	
	@Column(name="CREDITOR_CURRENCY_DATE")
	private String creditorCurrencyDate;
	
	@Column(name="EXCHANGE_RATE")
	private int exchangeRate;
	
	@Column(name="IS_URGENT")
	private boolean isUrgent;
	
	@Column(name="IS_INSTANT")
	private boolean isInstant;
	
	@Column(name="FEE_TYPE")
	private String feeType;
	
	@Column(name="FEE_ACCOUNT_ID")
	private String feeAccountId;
	
	@Column(name="HAS_TAX_RELIEF")
	private boolean hasTaxRelief;
	
	public Bonifico() {}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Account getCreditorAccount() {
		return creditorAccount;
	}

	public void setCreditorAccount(Account creditorAccount) {
		this.creditorAccount = creditorAccount;
	}

	public Account getDebtorAccount() {
		return debtorAccount;
	}

	public void setDebtorAccount(Account debtorAccount) {
		this.debtorAccount = debtorAccount;
	}

	public String getMoneyTransferId() {
		return moneyTransferId;
	}

	public void setMoneyTransferId(String moneyTransferId) {
		this.moneyTransferId = moneyTransferId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getCro() {
		return cro;
	}

	public void setCro(String cro) {
		this.cro = cro;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getTrn() {
		return trn;
	}

	public void setTrn(String trn) {
		this.trn = trn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(String createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public String getAccountedDatetime() {
		return accountedDatetime;
	}

	public void setAccountedDatetime(String accountedDatetime) {
		this.accountedDatetime = accountedDatetime;
	}

	public String getDebtorValueDate() {
		return debtorValueDate;
	}

	public void setDebtorValueDate(String debtorValueDate) {
		this.debtorValueDate = debtorValueDate;
	}

	public String getCreditorValueDate() {
		return creditorValueDate;
	}

	public void setCreditorValueDate(String creditorValueDate) {
		this.creditorValueDate = creditorValueDate;
	}

	public float getDebtorAmount() {
		return debtorAmount;
	}

	public void setDebtorAmount(float debtorAmount) {
		this.debtorAmount = debtorAmount;
	}

	public String getDebtorCurrency() {
		return debtorCurrency;
	}

	public void setDebtorCurrency(String debtorCurrency) {
		this.debtorCurrency = debtorCurrency;
	}

	public float getCreditorAmount() {
		return creditorAmount;
	}

	public void setCreditorAmount(float creditorAmount) {
		this.creditorAmount = creditorAmount;
	}

	public String getCreditorCurrency() {
		return creditorCurrency;
	}

	public void setCreditorCurrency(String creditorCurrency) {
		this.creditorCurrency = creditorCurrency;
	}

	public String getCreditorCurrencyDate() {
		return creditorCurrencyDate;
	}

	public void setCreditorCurrencyDate(String creditorCurrencyDate) {
		this.creditorCurrencyDate = creditorCurrencyDate;
	}

	public int getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(int exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public boolean isUrgent() {
		return isUrgent;
	}

	public void setUrgent(boolean isUrgent) {
		this.isUrgent = isUrgent;
	}

	public boolean isInstant() {
		return isInstant;
	}

	public void setInstant(boolean isInstant) {
		this.isInstant = isInstant;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public String getFeeAccountId() {
		return feeAccountId;
	}

	public void setFeeAccountId(String feeAccountId) {
		this.feeAccountId = feeAccountId;
	}

	public boolean isHasTaxRelief() {
		return hasTaxRelief;
	}

	public void setHasTaxRelief(boolean hasTaxRelief) {
		this.hasTaxRelief = hasTaxRelief;
	}
	
	

}
