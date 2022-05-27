package com.fabrick.esempio.req_resp;

public class BonificoFinalResp {

	private String status;
	private BonificoResponse bonificoResponse;
	private ErrorResponse error;
	
	public BonificoFinalResp() {}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BonificoResponse getBonificoResponse() {
		return bonificoResponse;
	}

	public void setBonificoResponse(BonificoResponse bonificoResponse) {
		this.bonificoResponse = bonificoResponse;
	}

	public ErrorResponse getError() {
		return error;
	}

	public void setError(ErrorResponse error) {
		this.error = error;
	}
	
	
	
}
