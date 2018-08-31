package com.pw.io.booker.repository.impl.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pw.io.booker.model.Reservation;
import com.pw.io.booker.repository.ReservationRepository;

@Repository
public class ReservationRepositoryMap implements ReservationRepository {

	private Map<Integer, Reservation> reservationMap = new HashMap<>();
	private int reservationIdGenerator = 1000;

	@Override
	public List<Reservation> findAll() {
		return new ArrayList<>(reservationMap.values());
	}

	@Override
	public Reservation findById(int id) {
		return reservationMap.get(id);
	}

	@Override
	public Reservation save(Reservation model) {
		if (findById(model.getReservationId()) != null) {
			reservationMap.put(model.getReservationId(), model);
			return model;
		}
		model.setReservationId(reservationIdGenerator++);
		reservationMap.put(model.getReservationId(), model);
		return model;
	}

	@Override
	public void delete(Reservation model) {
		reservationMap.remove(model.getReservationId());
	}

}
