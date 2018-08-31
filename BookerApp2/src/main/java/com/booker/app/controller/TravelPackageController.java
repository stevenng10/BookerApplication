package com.booker.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booker.app.model.TravelPackage;
import com.booker.app.service.TravelPackageService;

@RestController
@RequestMapping("/travel-packages")
public class TravelPackageController {

	private TravelPackageService travelPackageService;

	public TravelPackageController(TravelPackageService travelPackageService) {
		super();
		this.travelPackageService = travelPackageService;
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

	@GetMapping("/{travelPackageId}")
	public TravelPackage findById(@PathVariable("travelPackageId") int id) {
		return travelPackageService.findById(id);
	}

	@PutMapping("/{travelPackageId}")
	public TravelPackage updateById(@RequestBody TravelPackage travelPackage, @PathVariable int id) {
		travelPackage.setTravelPackageId(id);
		return travelPackageService.saveTravelPackage(travelPackage);
	}

	@DeleteMapping("/{travelPackageId}")
	public void deleteById(@PathVariable("travelPackageId") int id) {
		travelPackageService.deleteTravelPackage(travelPackageService.findById(id));
	}

}
