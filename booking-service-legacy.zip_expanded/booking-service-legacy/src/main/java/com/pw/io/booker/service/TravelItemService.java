package com.pw.io.booker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pw.io.booker.model.TravelItem;
import com.pw.io.booker.repository.list.TravelItemRepositoryList;

@Service
public class TravelItemService {

	private TravelItemRepositoryList travelItemRepositoryList;

	@Autowired
	public TravelItemService(TravelItemRepositoryList travelItemRepositoryList) {
		super();
		this.travelItemRepositoryList = travelItemRepositoryList;
	}

	public TravelItem findById(int travelId) {
		return travelItemRepositoryList.find(travelId);
	}

}
