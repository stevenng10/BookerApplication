package com.pw.io.booker.model;

import java.util.List;

/**
 * @author Jade Devin Cabatlao
 * 
 *         Consists of different services
 */
public class TravelPackage {

	private int travelPackageId;
	private String packageName;
	private List<TravelItem> availableItemList;
	private List<Image> images;
	private String description;

	public int getTravelPackageId() {
		return travelPackageId;
	}

	public void setTravelPackageId(int travelPackageId) {
		this.travelPackageId = travelPackageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public List<TravelItem> getAvailableItemList() {
		return availableItemList;
	}

	public void setAvailableItemList(List<TravelItem> availableItemList) {
		this.availableItemList = availableItemList;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}