package com.booker.app.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.booker.app.model.Image;
import com.booker.app.model.ServiceClass;
import com.booker.app.model.TravelPackage;
import com.booker.app.repository.TravelPackageRepository;

public class TravelPackageService {

	private TravelPackageRepository travelPackageRepository;
	private ServiceService serviceService;
	private ImageService imageService;

	public TravelPackageService(TravelPackageRepository travelPackageRepository, ServiceService serviceService,
			ImageService imageService) {
		super();
		this.travelPackageRepository = travelPackageRepository;
		this.serviceService = serviceService;
		this.imageService = imageService;
	}

	public TravelPackage findById(int id) {
		return travelPackageRepository.findById(id).get();
	}

	public Iterable<TravelPackage> findAll() {
		return travelPackageRepository.findAll();
	}

	@Transactional
	public List<TravelPackage> saveAllTravelPackage(List<TravelPackage> travelPackages) {
		for (TravelPackage travelPackage : travelPackages) {
			if (travelPackage.getAvailableServiceList() != null && travelPackage.getImage() != null) {
				for (ServiceClass service : travelPackage.getAvailableServiceList()) {
					service.setTravelPackage(travelPackage);
				}
				serviceService.saveAllService(travelPackage.getAvailableServiceList());
				for (Image image : travelPackage.getImage()) {
					image.setTravelPackage(travelPackage);
					imageService.saveImage(image);
				}
			} else if (travelPackage.getAvailableServiceList() != null && travelPackage.getImage() == null) {
				for (ServiceClass service : travelPackage.getAvailableServiceList()) {
					service.setTravelPackage(travelPackage);
				}
				serviceService.saveAllService(travelPackage.getAvailableServiceList());
			} else if (travelPackage.getAvailableServiceList() == null && travelPackage.getImage() != null) {
				for (Image image : travelPackage.getImage()) {
					image.setTravelPackage(travelPackage);
					imageService.saveImage(image);
				}
			}
			travelPackageRepository.save(travelPackage);
		}
		return travelPackages;
	}

	public void deleteTravelPackage(TravelPackage travelPackage) {
		travelPackageRepository.delete(travelPackage);
	}

	public void deleteAllTravelPackage(List<Integer> travelPackageId) {
		List<TravelPackage> travelPackages = (List<TravelPackage>) travelPackageRepository.findAllById(travelPackageId);
		for (TravelPackage travelPackage : travelPackages) {
			if (travelPackage.getAvailableServiceList() != null || travelPackage.getImage() != null) {
				for (ServiceClass service : travelPackage.getAvailableServiceList()) {
					serviceService.deleteService(service);
				}
				for (Image image : travelPackage.getImage()) {
					imageService.deleteImage(image);
				}
			} else if (travelPackage.getAvailableServiceList() != null || travelPackage.getImage() == null) {
				for (ServiceClass service : travelPackage.getAvailableServiceList()) {
					serviceService.deleteService(service);
				}
			} else if (travelPackage.getAvailableServiceList() == null || travelPackage.getImage() != null) {
				for (Image image : travelPackage.getImage()) {
					imageService.deleteImage(image);
				}
			}
			travelPackageRepository.delete(findById(travelPackage.getTravelPackageId()));
		}
	}
}