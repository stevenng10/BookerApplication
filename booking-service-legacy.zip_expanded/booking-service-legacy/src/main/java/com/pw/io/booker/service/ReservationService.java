package com.pw.io.booker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pw.io.booker.model.Reservation;
import com.pw.io.booker.model.ServiceFee;
import com.pw.io.booker.repository.list.ReservationRepositoryList;

@Service
public class ReservationService {

	private ReservationRepositoryList reservationRepositoryList;
	private TravelPackageService travelPackageService;

	@Autowired
	public ReservationService(ReservationRepositoryList reservationRepositoryList,
			TravelPackageService travelPackageService) {
		super();
		this.reservationRepositoryList = reservationRepositoryList;
		this.travelPackageService = travelPackageService;
	}

	public Reservation reserve(Reservation reservation) {
		// check availed services if it's in a travel package first
		if (travelPackageService.validateReservation(reservation)) {
			return reservationRepositoryList.save(reservation);
		} else {
			throw new Error("Availed services should be in a travel package");
		}
	}

	public Reservation cancel(Reservation reservation) {
		return reservationRepositoryList.delete(reservation);
	}

	public Reservation findById(int reservationId) {
		return reservationRepositoryList.find(reservationId);
	}

	public List<ServiceFee> retrievePaymentFee(Reservation reservation) {
		return null;
	}

}
