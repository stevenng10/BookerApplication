package com.booker.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booker.app.model.TravelPackage;
import com.booker.app.service.ServiceService;
import com.booker.app.service.TravelPackageService;

@RestController
@RequestMapping("/travel-packages")
public class TravelPackageController {

	private TravelPackageService travelPackageService;
	private ServiceService serviceService;

	public TravelPackageController(TravelPackageService travelPackageService, ServiceService serviceService) {
		super();
		this.travelPackageService = travelPackageService;
		this.serviceService = serviceService;
	}

	@GetMapping
	public Iterable<TravelPackage> getAllTravelPackages() {
		return travelPackageService.findAll();
	}

	@PostMapping
	public List<TravelPackage> insertAllTravelPackages(@RequestBody List<TravelPackage> travelPackages) {
		return travelPackageService.saveAllTravelPackage(travelPackages);
	}

	@PutMapping
	public List<TravelPackage> updateAllTravelPackages(@RequestBody List<TravelPackage> travelPackages) {
		return travelPackageService.saveAllTravelPackage(travelPackages);
	}

	@DeleteMapping
	public void deleteAllTravelPackages(@RequestParam("travelPackageId") List<Integer> travelPackageId) {
		travelPackageService.deleteAllTravelPackage(travelPackageId);
	}

}
