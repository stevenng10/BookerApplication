package com.booker.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.booker.app.model.ServiceFee;

@Repository
public interface ServiceFeeRepository extends CrudRepository<ServiceFee, Integer> {

}
