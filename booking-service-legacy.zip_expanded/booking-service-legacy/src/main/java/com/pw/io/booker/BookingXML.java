package com.pw.io.booker;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pw.io.booker.model.Reservation;
import com.pw.io.booker.model.TravelItem;
import com.pw.io.booker.service.ReservationService;
import com.pw.io.booker.service.TravelItemService;
import com.pw.io.booker.util.BookerServiceUtil;

public class BookingXML {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/pw/io/booker/ApplicationContext.xml");

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
