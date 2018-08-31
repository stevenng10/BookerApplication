package com.pw.io.booker.model;

import java.util.List;

/**
 * @author Jade Devin Cabatlao
 *
 *         Sample services are airline flights, land transfers, hotels, meals or
 *         other travel necessities
 */
public class TravelItem {

	private int itemId;
	private String serviceName;
	private String description;
	private List<Image> images;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
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