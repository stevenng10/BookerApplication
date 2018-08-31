package com.booker.app.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.booker.app.model.TravelPackage;
import com.booker.app.repository.TravelPackageRepository;

public class TravelPackageService {

	private TravelPackageRepository travelPackageRepository;

	public TravelPackageService(TravelPackageRepository travelPackageRepository) {
		super();
		this.travelPackageRepository = travelPackageRepository;
	}

	public TravelPackage findById(int id) {
		return travelPackageRepository.findById(id).get();
	}

	public Iterable<TravelPackage> findAll() {
		return travelPackageRepository.findAll();
	}

	@Transactional
	public List<TravelPackage> saveAllTravelPackage(List<TravelPackage> travelPackages) {
		return (List<TravelPackage>) travelPackageRepository.saveAll(travelPackages);
	}

	@Transactional
	public TravelPackage saveTravelPackage(TravelPackage travelPackage) {
		return travelPackageRepository.save(travelPackage);
	}

	public void deleteTravelPackage(TravelPackage travelPackage) {
		travelPackageRepository.delete(travelPackage);
	}

	public void deleteAllTravelPackage(List<Integer> travelPackageId) {
		travelPackageRepository.deleteAll(travelPackageRepository.findAllById(travelPackageId));
	}
}
