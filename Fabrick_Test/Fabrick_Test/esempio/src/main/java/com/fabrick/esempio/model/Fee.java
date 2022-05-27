package com.fabrick.esempio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Fee {

	@Id
	@GeneratedValue
	private Long id;
	
	@JoinColumn(name="FEE_CODE")
	private String feeCode;
	
	@JoinColumn(name="DESCRIPTION")
	private String description;
	
	@JoinColumn(name="AMOUNT")
	private float amount;
	
	@JoinColumn(name="CURRENCY")
	private String currency;
	
	public Fee() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFeeCode() {
		return feeCode;
	}

	public void setFeeCode(String feeCode) {
		this.feeCode = feeCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
}