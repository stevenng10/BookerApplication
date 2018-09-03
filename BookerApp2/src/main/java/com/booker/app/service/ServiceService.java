package com.booker.app.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.booker.app.model.ServiceClass;
import com.booker.app.model.TravelPackage;
import com.booker.app.repository.ServiceRepository;

public class ServiceService {

	private ServiceRepository serviceRepository;

	public ServiceService(ServiceRepository serviceRepository) {
		super();
		this.serviceRepository = serviceRepository;
	}

	public ServiceClass findById(int id) {
		return serviceRepository.findById(id).get();
	}

	public List<ServiceClass> findByAllId(List<Integer> ids) {
		return (List<ServiceClass>) serviceRepository.findAllById(ids);
	}

	public List<ServiceClass> findAll() {
		return (List<ServiceClass>) serviceRepository.findAll();
	}

	@Transactional
	public List<ServiceClass> saveAllService(List<ServiceClass> services, TravelPackage travelPackage) {
		for (ServiceClass service : services) {
			service.setTravelPackage(travelPackage);
		}
		return (List<ServiceClass>) serviceRepository.saveAll(services);
	}

	@Transactional
	public ServiceClass saveService(ServiceClass service) {
		return serviceRepository.save(service);
	}

	public void deleteAllService(List<Integer> serviceId) {
		serviceRepository.deleteAll(findByAllId(serviceId));
	}

	public void deleteService(Integer serviceId) {
		serviceRepository.delete(findById(serviceId));
	}

	public boolean doExist(int id) {
		return serviceRepository.existsById(id);
	}
}
