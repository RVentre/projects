package com.fabrick.esempio.repository;

import org.springframework.data.repository.CrudRepository;

import com.fabrick.esempio.model.Address;

public interface AddressRepository extends CrudRepository<Address, Long>{

	Address findByAddress(String address);
}
