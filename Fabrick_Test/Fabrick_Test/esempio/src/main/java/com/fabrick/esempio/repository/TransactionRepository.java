package com.fabrick.esempio.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fabrick.esempio.model.Account;
import com.fabrick.esempio.model.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Long>{

	
	List<Transaction> findAllByAccountAndValueDateBetween(Account account, Date valueDateStart, Date valueDateEnd);
}