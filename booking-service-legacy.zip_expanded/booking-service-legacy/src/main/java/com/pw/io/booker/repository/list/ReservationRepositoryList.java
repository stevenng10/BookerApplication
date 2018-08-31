package com.pw.io.booker.repository.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pw.io.booker.model.Reservation;

@Repository
public class ReservationRepositoryList {

	private List<Reservation> reservationList = new ArrayList<>();
	private int reservationIdGenerator = 1000;

	public List<Reservation> findAll() {
		return reservationList;
	}

	public Reservation find(int id) {
		for (Reservation reservation : reservationList) {
			if (id == reservation.getReservationId()) {
				return reservation;
			}
		}
		return null;
	}

	public Reservation save(Reservation model) {
		if (find(model.getReservationId()) != null) {
			reservationList.add(model);
		}
		model.setReservationId(reservationIdGenerator++);
		reservationList.add(model);
		return model;
	}

	public Reservation delete(Reservation model) {
		for (Iterator<Reservation> iter = reservationList.iterator(); iter.hasNext();) {
			Reservation reservation = iter.next();
			if (model.getReservationId() == reservation.getReservationId()) {
				iter.remove();
				return reservation;
			}
		}
		return null;
	}

}
