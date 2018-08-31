package com.pw.io.booker.model;

import java.time.LocalDate;

import javax.persistence.Entity;

/**
 * @author Jade Devin Cabatlao
 *
 */
@Entity
public class ServiceFee {

	private int serviceFeeId;
	private float amount;
	private TravelItem service;
	private LocalDate startDate;

	public int getServiceFeeId() {
		return serviceFeeId;
	}

	public void setServiceFeeId(int serviceFeeId) {
		this.serviceFeeId = serviceFeeId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public TravelItem getService() {
		return service;
	}

	public void setService(TravelItem service) {
		this.service = service;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

}
