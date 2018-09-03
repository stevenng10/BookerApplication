package com.booker.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private String firstName;
	private String lastName;
	@OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
	@JsonIgnore
	private List<Reservation> reservation;

	public int getCustomerId() {
		return customerId;
	}

	public List<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@PrePersist
	public void saveRelationships() {
		createRealtionships();
	}

	@PreUpdate
	public void updateRealtionships() {
		createRealtionships();
	}

	private void createRealtionships() {
		if (this.reservation != null) {
			for (Reservation reserve : this.reservation) {
				reserve.setCustomer(this);
			}
		}
	}
}
