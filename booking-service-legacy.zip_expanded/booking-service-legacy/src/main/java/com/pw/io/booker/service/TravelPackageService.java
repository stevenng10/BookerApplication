package com.pw.io.booker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pw.io.booker.model.Reservation;
import com.pw.io.booker.model.TravelItem;
import com.pw.io.booker.model.TravelPackage;
import com.pw.io.booker.repository.list.TravelPackageRepositoryList;

@Service("tps")
public class TravelPackageService {

	private TravelPackageRepositoryList travelPackageRepositoryList;

	@Autowired
	public TravelPackageService(TravelPackageRepositoryList travelPackageRepositoryList) {
		super();
		this.travelPackageRepositoryList = travelPackageRepositoryList;
	}

	public boolean validateReservation(Reservation reservation) {

		List<TravelPackage> travelPackageList = travelPackageRepositoryList.findAll();

		List<TravelItem> availedItems = reservation.getAvailedItemList();
		int totalAvailed = availedItems.size();
		int inPackageCtr = 0;
		for (TravelPackage travelPackage : travelPackageList) {
			inPackageCtr = 0;
			for (TravelItem travelItem : travelPackage.getAvailableItemList()) {
				for (TravelItem availedItem : availedItems) {
					if (travelItem.getItemId() == availedItem.getItemId()) {
						inPackageCtr++;
					}
				}
			}
			if (inPackageCtr == totalAvailed) {
				return true;
			}
		}
		return false;
	}

	public TravelPackage createPackage(TravelPackage travelPackage) {
		return travelPackageRepositoryList.save(travelPackage);
	}

	public List<TravelPackage> findAll() {
		return travelPackageRepositoryList.findAll();
	}
}
