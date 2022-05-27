package com.fabrick.esempio.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class BancaService {
	public Date convertDate(String date) throws ParseException {
		SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
		Date newDate = new Date();
		
		newDate = dateParser.parse(date);
		return newDate;
	}	
}
