package com.fabrick.esempio.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fabrick.esempio.model.Bonifico;
import com.fabrick.esempio.req_resp.Amount;
import com.fabrick.esempio.req_resp.BonificoResponse;
import com.fabrick.esempio.req_resp.Creditor;
import com.fabrick.esempio.req_resp.Debtor;
import com.fabrick.esempio.req_resp.InfoFee;

@Component
public class BonificoInfoDTO {

	public void fillBonificoData(BonificoResponse bonificoResponse, Bonifico bonifico, Creditor creditor, Debtor debtor, Amount amount, List<InfoFee> fees) {
		bonificoResponse.setCreditor(creditor);
		bonificoResponse.setDebtor(debtor);
		bonificoResponse.setAmount(amount);
		bonificoResponse.setFees(fees);
		
		bonificoResponse.setMoneyTransferId(bonifico.getMoneyTransferId());
		bonificoResponse.setStatus(bonifico.getStatus());
		bonificoResponse.setDirection(bonifico.getDirection());
		bonificoResponse.setCro(bonifico.getCro());
		bonificoResponse.setUri(bonifico.getUri());
		bonificoResponse.setTrn(bonifico.getTrn());
		bonificoResponse.setDescription(bonifico.getDescription());
		bonificoResponse.setCreatedDatetime(bonifico.getCreatedDateTime());
		bonificoResponse.setAccountedDatetime(bonifico.getAccountedDatetime());
		bonificoResponse.setDebtorValueDate(bonifico.getDebtorValueDate());
		bonificoResponse.setCreditorValueDate(bonifico.getCreditorValueDate());
		bonificoResponse.setUrgent(bonifico.isUrgent());
		bonificoResponse.setInstant(bonifico.isInstant());
		bonificoResponse.setFeeType(bonifico.getFeeType());
		bonificoResponse.setFeeAccountId(bonifico.getFeeAccountId());
		bonificoResponse.setHasTaxRelief(bonifico.isHasTaxRelief());
	}
}
