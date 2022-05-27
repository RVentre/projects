package com.fabrick.esempio.req_resp;

public class LegalPersonBeneficiary {

	private String fiscalCode;
	private String legalRepresentativeFiscalCode;
	
	public String getFiscalCode() {
		return fiscalCode;
	}
	public void setFiscalCode(String fiscalCode) {
		this.fiscalCode = fiscalCode;
	}
	public String getLegalRepresentativeFiscalCode() {
		return legalRepresentativeFiscalCode;
	}
	public void setLegalRepresentativeFiscalCode(String legalRepresentativeFiscalCode) {
		this.legalRepresentativeFiscalCode = legalRepresentativeFiscalCode;
	}
	public LegalPersonBeneficiary(String fiscalCode, String legalRepresentativeFiscalCode) {
		this.fiscalCode = fiscalCode;
		this.legalRepresentativeFiscalCode = legalRepresentativeFiscalCode;
	}
	
	
	
}
