package com.pw.io.booker;

import java.util.ArrayList;
import java.util.List;

import com.pw.io.booker.model.Reservation;
import com.pw.io.booker.model.TravelItem;
import com.pw.io.booker.repository.list.ReservationRepositoryList;
import com.pw.io.booker.repository.list.TravelItemRepositoryList;
import com.pw.io.booker.repository.list.TravelPackageRepositoryList;
import com.pw.io.booker.service.ReservationService;
import com.pw.io.booker.service.TravelItemService;
import com.pw.io.booker.service.TravelPackageService;
import com.pw.io.booker.util.BookerServiceUtil;

public class BookerServiceApplication {

	private static BookerServiceUtil bookerServiceUtil;

	public static void main(String[] args) {

		TravelPackageRepositoryList travelPackageRepositoryList = new TravelPackageRepositoryList();
		TravelPackageService travelPackageService = new TravelPackageService(travelPackageRepositoryList);

		ReservationService reservationService = new ReservationService(new ReservationRepositoryList(),
				travelPackageService);

		TravelItemRepositoryList travelItemRepositroyList = new TravelItemRepositoryList();
		TravelItemService travelItemService = new TravelItemService(travelItemRepositroyList);

		initData(travelItemRepositroyList, travelPackageRepositoryList);

		Reservation reservation = new Reservation();
		List<TravelItem> travelItemList = new ArrayList<>();
		travelItemList.add(travelItemService.findById(1001));
		reservation.setAvailedItemList(travelItemList);
		reservationService.reserve(reservation);
		System.out.println("Success");
	}

	private static void initData(TravelItemRepositoryList travelItemRepositroyList,
			TravelPackageRepositoryList travelPackageRepositoryList) {
		bookerServiceUtil = new BookerServiceUtil(travelItemRepositroyList, travelPackageRepositoryList);
		bookerServiceUtil.initializeData();
	}
}
