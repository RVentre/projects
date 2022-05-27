package com.fabrick.esempio.req_resp;

public class InfoAccount {

	private String accountCode;
	private String bicCode;
	
	
	public String getAccountCode() {
		return accountCode;
	}
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}
	public String getBicCode() {
		return bicCode;
	}
	public void setBicCode(String bicCode) {
		this.bicCode = bicCode;
	}
	public InfoAccount(String accountCode, String bicCode) {
		this.accountCode = accountCode;
		this.bicCode = bicCode;
	}
	
	
	
}
