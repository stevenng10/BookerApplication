package com.pw.io.booker.model;

import java.time.LocalDate;

/**
 * @author Jade Devin Cabatlao
 *
 */
public class ServiceFee {

	private int serviceFeeId;
	private float amount;
	private TravelItem item;
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

	public TravelItem getItem() {
		return item;
	}

	public void setItem(TravelItem item) {
		this.item = item;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

}
