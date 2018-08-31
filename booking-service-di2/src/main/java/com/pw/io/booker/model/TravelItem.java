package com.pw.io.booker.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Jade Devin Cabatlao
 *
 *         Sample services are airline flights, land transfers, hotels, meals or
 *         other travel necessities
 */
@Entity
public class TravelItem {

	@Id
	private int itemId;
	private String itemName;
	private String description;
	@OneToMany
	private List<Image> images;

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
