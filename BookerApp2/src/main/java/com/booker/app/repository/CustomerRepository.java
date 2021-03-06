package com.booker.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.booker.app.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
