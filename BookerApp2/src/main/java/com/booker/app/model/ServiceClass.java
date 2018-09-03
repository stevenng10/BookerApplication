package com.booker.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ServiceClass {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int serviceId;
	private String serviceName;
	private String description;
	@OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
	private List<Image> image;
	@ManyToMany(mappedBy = "availedServiceList", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Reservation> reservations;
	@OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<ServiceFee> serviceFee;
	@ManyToOne
	@JoinColumn(name = "travelPackageId")
	@JsonIgnore
	private TravelPackage travelPackage;

	public List<ServiceFee> getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(List<ServiceFee> serviceFee) {
		this.serviceFee = serviceFee;
	}

	public TravelPackage getTravelPackage() {
		return travelPackage;
	}

	public void setTravelPackage(TravelPackage travelPackage) {
		this.travelPackage = travelPackage;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
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

	public List<Image> getImage() {
		return image;
	}

	public void setImage(List<Image> image) {
		this.image = image;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
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
		if (this.image != null) {
			for (Image image : this.image) {
				image.setService(this);
			}
		}
	}
}
