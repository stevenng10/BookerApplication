package com.pw.io.booker.service;

import java.util.List;

import com.pw.io.booker.model.Reservation;
import com.pw.io.booker.model.ServiceFee;
import com.pw.io.booker.repository.ReservationRepository;

public class ReservationService {

	private ReservationRepository reservationRepository;
	private TravelPackageService travelPackageService;

	public ReservationService(ReservationRepository reservationRepository,
			TravelPackageService travelPackageService) {
		super();
		this.reservationRepository = reservationRepository;
		this.travelPackageService = travelPackageService;
	}

	public Reservation reserve(Reservation reservation) {
		//check availed services if it's in a travel package first
		if(travelPackageService.validateReservation(reservation)) {			
			return reservationRepository.save(reservation);
		}
		else
		{
			throw new Error("Availed services should be in a travel package");
		}
	}

	public void cancel(Reservation reservation) {
		reservationRepository.delete(reservation);
	}
	
	public Reservation findById(int reservationId) {
		return reservationRepository.findById(reservationId);
	}
	
	public List<ServiceFee> retrievePaymentFee(Reservation reservation) {
		return null;
	}
	
	
}
