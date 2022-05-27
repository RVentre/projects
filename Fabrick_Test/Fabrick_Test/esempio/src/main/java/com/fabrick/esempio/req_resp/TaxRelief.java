package com.fabrick.esempio.req_resp;

public class TaxRelief {

	private String taxReliefId;
	private boolean isCondoUpgrade;
	private String creditorFiscalCode;
	private NaturalPersonBeneficiary naturalPersonBeneficiary;
	private LegalPersonBeneficiary legalPersonBeneficiary;
	
	public String getTaxReliefId() {
		return taxReliefId;
	}
	public void setTaxReliefId(String taxReliefId) {
		this.taxReliefId = taxReliefId;
	}
	public boolean isCondoUpgrade() {
		return isCondoUpgrade;
	}
	public void setCondoUpgrade(boolean isCondoUpgrade) {
		this.isCondoUpgrade = isCondoUpgrade;
	}
	public String getCreditorFiscalCode() {
		return creditorFiscalCode;
	}
	public void setCreditorFiscalCode(String creditorFiscalCode) {
		this.creditorFiscalCode = creditorFiscalCode;
	}
	public NaturalPersonBeneficiary getNaturalPersonBeneficiary() {
		return naturalPersonBeneficiary;
	}
	public void setNaturalPersonBeneficiary(NaturalPersonBeneficiary naturalPersonBeneficiary) {
		this.naturalPersonBeneficiary = naturalPersonBeneficiary;
	}
	public LegalPersonBeneficiary getLegalPersonBeneficiary() {
		return legalPersonBeneficiary;
	}
	public void setLegalPersonBeneficiary(LegalPersonBeneficiary legalPersonBeneficiary) {
		this.legalPersonBeneficiary = legalPersonBeneficiary;
	}
	
	public TaxRelief(String taxReliefId, boolean isCondoUpgrade, String creditorFiscalCode,
			NaturalPersonBeneficiary naturalPersonBeneficiary, LegalPersonBeneficiary legalPersonBeneficiary) {
		this.taxReliefId = taxReliefId;
		this.isCondoUpgrade = isCondoUpgrade;
		this.creditorFiscalCode = creditorFiscalCode;
		this.naturalPersonBeneficiary = naturalPersonBeneficiary;
		this.legalPersonBeneficiary = legalPersonBeneficiary;
	}
	
	
	
}
