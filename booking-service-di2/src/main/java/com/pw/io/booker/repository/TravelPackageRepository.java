package com.pw.io.booker.repository;

import java.util.List;

import com.pw.io.booker.model.TravelPackage;

public interface TravelPackageRepository extends Repository<TravelPackage> {

	List<TravelPackage> findByDescription(String description);

}
