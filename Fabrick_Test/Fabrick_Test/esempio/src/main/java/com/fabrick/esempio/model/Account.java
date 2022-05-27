package com.fabrick.esempio.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Account {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "ACCOUNT_ID")
	private String accountId;
	
	@Column(name = "IBAN")
	private String iban;
	
	@Column(name="ABI_CODE")
	private String abiCode;
	
	@Column(name="CAB_CODE")
	private String cabCode;
	
	@Column(name="COUNTRY_CODE")
	private String countryCode;
	
	@Column(name="INTERNATIONAL_CIN")
	private String internationalCin;
	
	@Column(name="ACCOUNT")
	private String account;
	
	@Column(name="ALIAS")
	private String alias;
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="HOLDER_NAME")
	private String holderName;
	
	@Column(name="ACTIVATED_DATE")
	private String activatedDate;
	
	@Column(name="CURRENCY")
	private String currency;
	
	@Column(name="BIC_CODE")
	private String bicCode;
	
	@ManyToOne
	@JoinColumn(name="INTESTATARIO")
	private Person intestatario;
	
	@OneToMany(mappedBy = "account")
	private List<Transaction> transactions;
	
	
	public Account() {};

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public String getBicCode() {
		return bicCode;
	}

	public void setBicCode(String bicCode) {
		this.bicCode = bicCode;
	}

	public Person getIntestatario() {
		return intestatario;
	}

	public void setIntestatario(Person person) {
		this.intestatario = person;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getAbiCode() {
		return abiCode;
	}

	public void setAbiCode(String abiCode) {
		this.abiCode = abiCode;
	}

	public String getCabCode() {
		return cabCode;
	}

	public void setCabCode(String cabCode) {
		this.cabCode = cabCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getInternationalCin() {
		return internationalCin;
	}

	public void setInternationalCin(String internationalCin) {
		this.internationalCin = internationalCin;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getActivatedDate() {
		return activatedDate;
	}

	public void setActivatedDate(String activatedDate) {
		this.activatedDate = activatedDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
