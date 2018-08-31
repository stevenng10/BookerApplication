package com.booker.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.booker.app.model.ServiceClass;

@Repository
public interface ServiceRepository extends CrudRepository<ServiceClass, Integer> {

}
