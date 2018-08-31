package com.booker.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.booker.app.model.Image;
import com.booker.app.model.ServiceClass;
import com.booker.app.repository.ServiceRepository;

@Service
public class ServiceService {

	private ServiceRepository serviceRepository;
	private ImageService imageService;

	public ServiceService(ServiceRepository serviceRepository, ImageService imageService) {
		super();
		this.serviceRepository = serviceRepository;
		this.imageService = imageService;
	}

	public ServiceClass findById(int id) {
		return serviceRepository.findById(id).get();
	}

	public List<ServiceClass> findAll() {
		return (List<ServiceClass>) serviceRepository.findAll();
	}

	@Transactional
	public List<ServiceClass> saveAllService(List<ServiceClass> services) {
		for (ServiceClass service : services) {
			if (service.getImage() == null) {
				serviceRepository.save(service);
			} else {
				for (Image image : service.getImage()) {
					image.setService(service);
					imageService.saveImage(image);
				}
				serviceRepository.save(service);
			}
		}
		return services;
	}

	@Transactional
	public ServiceClass saveService(ServiceClass service) {
		if (service.getImage() == null) {
			return serviceRepository.save(service);
		} else {

			imageService.saveAllImage(service.getImage());
			return serviceRepository.save(service);
		}
	}

	public void deleteService(ServiceClass service) {
		serviceRepository.delete(service);
	}
}
