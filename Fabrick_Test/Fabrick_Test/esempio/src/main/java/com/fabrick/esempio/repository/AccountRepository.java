package com.fabrick.esempio.repository;

import org.springframework.data.repository.CrudRepository;

import com.fabrick.esempio.model.Account;

public interface AccountRepository extends CrudRepository<Account, Long>{

	Account findByIban(String iban);
}
