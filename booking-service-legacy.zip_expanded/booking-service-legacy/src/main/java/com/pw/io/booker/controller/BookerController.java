package com.pw.io.booker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pw.io.booker.model.TravelItem;
import com.pw.io.booker.model.TravelPackage;
import com.pw.io.booker.service.TravelItemService;
import com.pw.io.booker.service.TravelPackageService;

@RestController
public class BookerController {

	private TravelPackageService travelPackageService;
	private TravelItemService travelItemService;

	public BookerController(TravelPackageService travelPackageService, TravelItemService travelItemService) {
		this.travelPackageService = travelPackageService;
		this.travelItemService = travelItemService;
	}

	@RequestMapping("/travel-packages")
	@ResponseBody
	public List<TravelPackage> getAllTPS() {
		return travelPackageService.findAll();
	}

	@RequestMapping("/travel-items/{id}")
	@ResponseBody
	public TravelItem findId(@PathVariable("id") int id) {
		return travelItemService.findById(id);
	}
}
