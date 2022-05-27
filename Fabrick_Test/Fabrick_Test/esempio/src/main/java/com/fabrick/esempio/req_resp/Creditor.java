package com.fabrick.esempio.req_resp;

public class Creditor {
	
	private String name;
	private InfoAccount account;
	private InfoAddress address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public InfoAccount getAccount() {
		return account;
	}

	public void setAccount(InfoAccount account) {
		this.account = account;
	}

	public InfoAddress getAddress() {
		return address;
	}

	public void setAddress(InfoAddress address) {
		this.address = address;
	}

	public Creditor() {	}
	
	

}
