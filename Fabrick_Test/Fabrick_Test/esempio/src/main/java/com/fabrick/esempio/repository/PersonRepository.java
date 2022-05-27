package com.fabrick.esempio.repository;

import org.springframework.data.repository.CrudRepository;

import com.fabrick.esempio.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long>{

	Person findByName(String name);
}
