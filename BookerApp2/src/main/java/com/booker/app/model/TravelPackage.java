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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

@Entity
@JsonIdentityInfo(generator = PropertyGenerator.class, property = "travelPackageId")
public class TravelPackage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int travelPackageId;
	private String packageName;
	@OneToMany(mappedBy = "travelPackage", cascade = CascadeType.ALL)
	private List<ServiceClass> availableServiceList;
	@OneToMany(mappedBy = "travelPackage", cascade = CascadeType.ALL)
	private List<Image> image;
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

	public List<ServiceClass> getAvailableServiceList() {
		return availableServiceList;
	}

	public void setAvailableServiceList(List<ServiceClass> availableServiceList) {
		this.availableServiceList = availableServiceList;
	}

	public List<Image> getImage() {
		return image;
	}

	public void setImage(List<Image> image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		if (this.availableServiceList != null) {
			for (ServiceClass service : this.availableServiceList) {
				service.setTravelPackage(this);
			}
		}

		if (this.image != null) {
			for (Image image : this.image) {
				image.setTravelPackage(this);
			}

		}
	}
}
