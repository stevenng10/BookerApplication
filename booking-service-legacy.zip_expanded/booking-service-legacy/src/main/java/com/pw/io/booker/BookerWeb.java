package com.pw.io.booker;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.pw.io.booker.model.Reservation;
import com.pw.io.booker.model.TravelItem;
import com.pw.io.booker.service.ReservationService;
import com.pw.io.booker.service.TravelItemService;
import com.pw.io.booker.util.BookerServiceUtil;

@SpringBootApplication(scanBasePackages = { "com.pw.io.booker.config", "com.pw.io.booker.controller",
		"com.pw.io.booker.repository.list" })
public class BookerWeb {

	public static void main(String[] args) {
		SpringApplication.run(BookerWeb.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext context) {
		return args -> {

			BookerServiceUtil booker = context.getBean("bookerServiceUtil", BookerServiceUtil.class);
			booker.initializeData();
			Reservation reservation = new Reservation();
			List<TravelItem> travelItemList = new ArrayList<>();
			travelItemList.add(context.getBean("travelItemService", TravelItemService.class).findById(1001));
			reservation.setAvailedItemList(travelItemList);
			System.out.println(context.getBean("reservationService", ReservationService.class).reserve(reservation));
			System.out.println("SUCCESS");
		};
	}
}
