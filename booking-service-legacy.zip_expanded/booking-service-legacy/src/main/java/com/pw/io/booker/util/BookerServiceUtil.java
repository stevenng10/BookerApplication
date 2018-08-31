package com.pw.io.booker.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pw.io.booker.model.TravelItem;
import com.pw.io.booker.model.TravelPackage;
import com.pw.io.booker.repository.list.TravelItemRepositoryList;
import com.pw.io.booker.repository.list.TravelPackageRepositoryList;

@Service
public class BookerServiceUtil {

	private TravelItemRepositoryList travelItemRepositoryList;
	private TravelPackageRepositoryList travelPackageRepositoryList;
	private static final int TRAVEL_ITEM_LIMIT = 5;

	@Autowired
	public BookerServiceUtil() {

	}

	public BookerServiceUtil(TravelItemRepositoryList travelItemRepositoryList,
			TravelPackageRepositoryList travelPackageRepositoryList) {
		super();
		this.travelItemRepositoryList = travelItemRepositoryList;
		this.travelPackageRepositoryList = travelPackageRepositoryList;
	}

	/**
	 * @return Generates travel packages with TRAVEL_ITEM_LIMIT number of travel
	 *         items
	 */
	public TravelPackage generateTravelPackage() {
		TravelPackage travelPackage = new TravelPackage();

		TravelItem travelItem = null;
		List<TravelItem> travelItemList = new ArrayList<>();
		for (int ctr = 0; ctr < TRAVEL_ITEM_LIMIT; ctr++) {
			travelItem = travelItemRepositoryList.save(generateTravelItem());
			travelItemList.add(travelItem);
		}

		travelPackage.setAvailableItemList(travelItemList);
		return travelPackage;
	}

	@Autowired
	public void setTravelItemRepositoryList(TravelItemRepositoryList travelItemRepositoryList) {
		this.travelItemRepositoryList = travelItemRepositoryList;
	}

	@Autowired
	public void setTravelPackageRepositoryList(TravelPackageRepositoryList travelPackageRepositoryList) {
		this.travelPackageRepositoryList = travelPackageRepositoryList;
	}

	public TravelItem generateTravelItem() {
		return new TravelItem();
	}

	public void initializeData() {
		travelPackageRepositoryList.save(generateTravelPackage());
		travelPackageRepositoryList.save(generateTravelPackage());
		travelItemRepositoryList.save(generateTravelItem());
	}

}
