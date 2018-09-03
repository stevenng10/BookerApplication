package com.booker.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booker.app.model.Reservation;
import com.booker.app.service.ReservationService;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

	private ReservationService reservationService;

	public ReservationController(ReservationService reservationService) {
		super();
		this.reservationService = reservationService;
	}

	@GetMapping
	public List<Reservation> getAllReservations() {
		return reservationService.findAll();
	}

	@PostMapping
	public List<Reservation> insertAllReservations(@RequestBody List<Reservation> reservations) {
		return reservationService.saveAllReservation(reservations);
	}

	@PutMapping
	public List<Reservation> updateAllReservations(@RequestBody List<Reservation> reservations) {
		return reservationService.saveAllReservation(reservations);
	}

	@DeleteMapping
	public void deleteAllReservations(@RequestParam("reservationId") List<Integer> reservationId) {
		reservationService.deleteAllReservation(reservationId);
	}

	@GetMapping("/{reservationId}")
	public Reservation getReservation(@PathVariable int id) {
		return reservationService.findById(id);
	}

	@PutMapping("/{reservationId}")
	public Reservation updateReservations(@PathVariable int id, @RequestBody Reservation reservation) {
		reservation.setReservationId(id);
		return reservationService.saveReservation(reservation);
	}

	@DeleteMapping("/{reservationId}")
	public void deleteReservations(@PathVariable int id) {
		reservationService.deleteReservation(reservationService.findById(id));
	}
}
