package com.booker.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.booker.app.model.TravelPackage;

@Repository
public interface TravelPackageRepository extends CrudRepository<TravelPackage, Integer> {

}
