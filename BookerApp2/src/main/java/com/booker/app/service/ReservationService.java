package com.booker.app.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.booker.app.model.Reservation;
import com.booker.app.repository.ReservationRepository;

public class ReservationService {

	private ReservationRepository reservationRepository;

	public ReservationService(ReservationRepository reservationRepository) {
		super();
		this.reservationRepository = reservationRepository;
	}

	public Reservation findById(int id) {
		return reservationRepository.findById(id).get();
	}

	public List<Reservation> findAll() {
		return (List<Reservation>) reservationRepository.findAll();
	}

	public List<Reservation> saveAllReservation(List<Reservation> reservations) {
		return (List<Reservation>) reservationRepository.saveAll(reservations);
	}

	@Transactional
	public Reservation saveReservation(Reservation reservation) {
		return reservationRepository.save(reservation);
	}

	public void deleteReservation(Reservation reservation) {
		reservationRepository.delete(reservation);
	}
}
