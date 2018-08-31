package com.pw.io.booker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pw.io.booker.repository.FeedbackRepository;
import com.pw.io.booker.repository.ReservationRepository;
import com.pw.io.booker.repository.TravelItemRepository;
import com.pw.io.booker.repository.TravelPackageRepository;
import com.pw.io.booker.repository.impl.map.FeedbackRepositoryMap;
import com.pw.io.booker.repository.impl.map.ReservationRepositoryMap;
import com.pw.io.booker.repository.impl.map.TravelItemRepositoryMap;
import com.pw.io.booker.repository.impl.map.TravelPackageRepositoryMap;


@Configuration
public class RepositoryConfig {

	@Bean
	public TravelPackageRepository travelPackageRepository() {
		return new TravelPackageRepositoryMap();
	}

	@Bean
	public ReservationRepository reservationRepository() {
		return new ReservationRepositoryMap();
	}

	@Bean
	public FeedbackRepository feedbackRepository() {
		return new FeedbackRepositoryMap();
	}
	
	@Bean
	public TravelItemRepository travelItemRepository() {
		return new TravelItemRepositoryMap();
	}
}
