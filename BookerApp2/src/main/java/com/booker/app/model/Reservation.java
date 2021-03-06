package com.booker.app.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reservationId;
	@ManyToMany
	@JoinTable
	private List<ServiceClass> availedServiceList;
	private LocalDate startDate;
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;
	@OneToMany(mappedBy = "reservation")
	private List<Feedback> feedback;

	public List<Feedback> getFeedback() {
		return feedback;
	}

	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public List<ServiceClass> getAvailedServiceList() {
		return availedServiceList;
	}

	public void setAvailedServiceList(List<ServiceClass> availedServiceList) {
		this.availedServiceList = availedServiceList;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
