package com.fabrick.esempio.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fabrick.esempio.model.Fee;
import com.fabrick.esempio.req_resp.InfoFee;


@Component
public class FeeInfoDTO {

	public void fillDataFees(List<InfoFee> infoFees, Iterable<Fee> fees) {
		fees.forEach(fee -> {
			infoFees.add(mapp(fee));
		});
		
	}
	
	public InfoFee mapp(Fee fee) {
		InfoFee infoFee = new InfoFee();
		String feeCode = fee.getFeeCode()!=null ? fee.getFeeCode() : "";
		infoFee.setFeeCode(feeCode);
		String description = fee.getDescription()!=null ? fee.getDescription() : "";
		infoFee.setDescription(description);
		String currency = fee.getCurrency()!=null ? fee.getCurrency() : "";
		infoFee.setCurrency(currency);
		float amount = fee.getAmount()!=0 ? fee.getAmount() : 0;
		infoFee.setAmount(amount);
		return infoFee;
	}
}
