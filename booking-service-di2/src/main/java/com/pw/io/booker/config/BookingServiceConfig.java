package com.pw.io.booker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pw.io.booker.repository.ReservationRepository;
import com.pw.io.booker.repository.TravelItemRepository;
import com.pw.io.booker.repository.TravelPackageRepository;
import com.pw.io.booker.service.ReservationService;
import com.pw.io.booker.service.TravelItemService;
import com.pw.io.booker.service.TravelPackageService;
import com.pw.io.booker.util.BookerServiceUtil;

@Configuration
public class BookingServiceConfig {

	@Bean
	public ReservationService reservationService(ReservationRepository reservationRepository,
			TravelPackageService travelPackageService) {
		return new ReservationService(reservationRepository, travelPackageService);
	}

	@Bean
	public TravelPackageService travelPackageService(TravelPackageRepository travelPackageRepository) {
		return new TravelPackageService(travelPackageRepository);
	}

	@Bean
	public TravelItemService travelItemService(TravelItemRepository travelItemRepository) {
		return new TravelItemService(travelItemRepository);
	}

	@Bean
	public BookerServiceUtil bookerServiceUtil(TravelItemRepository travelItemRepository,
			TravelPackageRepository travelPackageRepository) {
		return new BookerServiceUtil(travelItemRepository, travelPackageRepository);
	}

}
