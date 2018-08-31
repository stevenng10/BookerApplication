package com.pw.io.booker.model;

import java.util.List;

import javax.persistence.Entity;

/**
 * @author Jade Devin Cabatlao
 *
 *         Sample services are airline flights, land transfers, hotels, meals or
 *         other travel necessities
 */
@Entity
public class TravelItem {

	private int itemId;
	private String itemName;
	private String description;
	private List<Image> images;
	private TravelPackage travelPackage;

	public TravelPackage getTravelPackage() {
		return travelPackage;
	}

	public void setTravelPackage(TravelPackage travelPackage) {
		this.travelPackage = travelPackage;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

}