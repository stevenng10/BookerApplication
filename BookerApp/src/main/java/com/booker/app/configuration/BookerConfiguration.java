package com.booker.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.booker.app.repository.CustomerRepository;
import com.booker.app.repository.ImageRepository;
import com.booker.app.repository.ReservationRepository;
import com.booker.app.repository.ServiceRepository;
import com.booker.app.repository.TravelPackageRepository;
import com.booker.app.service.CustomerService;
import com.booker.app.service.ImageService;
import com.booker.app.service.ReservationService;
import com.booker.app.service.ServiceService;
import com.booker.app.service.TravelPackageService;

@Configuration
public class BookerConfiguration {

	@Bean
	public TravelPackageService travelPackageService(TravelPackageRepository travelPackageRepository,
			ServiceService serviceService, ImageService imageService) {
		return new TravelPackageService(travelPackageRepository, serviceService, imageService);
	}

	@Bean
	public ServiceService serviceService(ServiceRepository serviceRepository, ImageService imageService) {
		return new ServiceService(serviceRepository, imageService);
	}

	@Bean
	public ImageService imageService(ImageRepository imageRepository) {
		return new ImageService(imageRepository);
	}

	@Bean
	public CustomerService customerService(CustomerRepository customerRepository,
			ReservationService reservationService) {
		return new CustomerService(customerRepository, reservationService);
	}

	@Bean
	public ReservationService reservationService(ReservationRepository reservationRepository) {
		return new ReservationService(reservationRepository);
	}
}
