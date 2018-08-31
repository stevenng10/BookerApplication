package com.pw.io.booker;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.pw.io.booker.model.Reservation;
import com.pw.io.booker.model.TravelItem;
import com.pw.io.booker.service.ReservationService;
import com.pw.io.booker.service.TravelItemService;
import com.pw.io.booker.util.BookerServiceUtil;

@Configuration
@ComponentScan({ "com.pw.io.booker.repository.list", "com.pw.io.booker.service", "com.pw.io.booker.service",
		"com.pw.io.booker.util" })
public class BookingAnnotation {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(BookingAnnotation.class);

		initData(context.getBean("bookerServiceUtil", BookerServiceUtil.class));
		Reservation reservation = new Reservation();
		List<TravelItem> travelItemList = new ArrayList<>();
		travelItemList.add(context.getBean("travelItemService", TravelItemService.class).findById(1001));
		reservation.setAvailedItemList(travelItemList);
		System.out.println(context.getBean("reservationService", ReservationService.class).reserve(reservation));
		System.out.println("SUCCESS");
	}

	private static void initData(BookerServiceUtil booker) {
		booker.initializeData();
	}

}
