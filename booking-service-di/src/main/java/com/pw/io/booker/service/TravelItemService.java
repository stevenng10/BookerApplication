package com.pw.io.booker.service;

import java.util.List;

import com.pw.io.booker.model.TravelItem;
import com.pw.io.booker.repository.TravelItemRepository;

public class TravelItemService {

	private TravelItemRepository travelItemRepository;

	public TravelItemService(TravelItemRepository travelItemRepository) {
		super();
		this.travelItemRepository = travelItemRepository;
	}

	public TravelItem findById(int travelId) {
		return travelItemRepository.findById(travelId);
	}

	public List<TravelItem> findAll() {
		return travelItemRepository.findAll();
	}
}