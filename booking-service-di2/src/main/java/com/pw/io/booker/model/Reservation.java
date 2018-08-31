package com.pw.io.booker.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Jade Devin Cabatlao
 *
 */
@Entity
public class Reservation {

	@Id
	private int reservationId;
	@OneToMany
	private List<TravelItem> availedItemList;
	@ManyToOne
	private Customer customer;
	private LocalDate departureDate;

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public List<TravelItem> getAvailedItemList() {
		return availedItemList;
	}

	public void setAvailedItemList(List<TravelItem> availedItemList) {
		this.availedItemList = availedItemList;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

}
