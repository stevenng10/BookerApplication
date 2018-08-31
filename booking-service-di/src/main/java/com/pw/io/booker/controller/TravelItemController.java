package com.pw.io.booker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pw.io.booker.model.TravelItem;
import com.pw.io.booker.service.TravelItemService;

@RestController
@RequestMapping("/travel-items")
public class TravelItemController {

	private TravelItemService travelItemService;

	public TravelItemController(TravelItemService travelItemService) {
		super();
		this.travelItemService = travelItemService;
	}

	@GetMapping
	public List<TravelItem> getTravelItems() {
		return travelItemService.findAll();
	}
}
