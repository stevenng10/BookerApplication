package com.pw.io.booker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pw.io.booker.repository.list.ReservationRepositoryList;
import com.pw.io.booker.repository.list.TravelItemRepositoryList;
import com.pw.io.booker.repository.list.TravelPackageRepositoryList;
import com.pw.io.booker.service.ReservationService;
import com.pw.io.booker.service.TravelItemService;
import com.pw.io.booker.service.TravelPackageService;
import com.pw.io.booker.util.BookerServiceUtil;

@Configuration
public class ServiceConfig {

	@Bean
	public ReservationService reservationService(ReservationRepositoryList reservationRepositoryList,
			TravelPackageService travelPackageService) {
		return new ReservationService(reservationRepositoryList, travelPackageService);
	}

	@Bean
	public TravelPackageService travelPackageService(TravelPackageRepositoryList travelPackageRepositoryList) {
		return new TravelPackageService(travelPackageRepositoryList);
	}

	@Bean
	public TravelItemService travelItemService(TravelItemRepositoryList travelItemRepositoryList) {
		return new TravelItemService(travelItemRepositoryList);
	}

	@Bean
	public BookerServiceUtil bookerServiceUtil(TravelItemRepositoryList travelItemRepositoryList,
			TravelPackageRepositoryList travelPackageRepositoryList) {
		return new BookerServiceUtil(travelItemRepositoryList, travelPackageRepositoryList);
	}
}