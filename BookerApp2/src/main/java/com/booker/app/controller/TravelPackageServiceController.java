package com.booker.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booker.app.model.ServiceClass;
import com.booker.app.model.TravelPackage;
import com.booker.app.service.ServiceService;
import com.booker.app.service.TravelPackageService;

@RestController
@RequestMapping("/travel-packages/{travelPackageId}/services")
public class TravelPackageServiceController {

	private TravelPackageService travelPackageService;
	private ServiceService serviceService;

	public TravelPackageServiceController(TravelPackageService travelPackageService, ServiceService serviceService) {
		super();
		this.travelPackageService = travelPackageService;
		this.serviceService = serviceService;
	}

	public TravelPackage findById(@PathVariable("travelPackageId") int id) {
		return travelPackageService.findById(id);
	}

	@GetMapping
	public List<ServiceClass> findAllByServiceId(@PathVariable("travelPackageId") int id) {
		return findById(id).getAvailableServiceList();
	}

	@PostMapping
	public List<ServiceClass> insertAllService(@PathVariable("travelPackageId") int id,
			@RequestBody List<ServiceClass> services) {
		return serviceService.saveAllService(services, findById(id));
	}

	@PutMapping
	public List<ServiceClass> updateAllServices(@PathVariable("travelPackageId") int id,
			@RequestBody List<ServiceClass> services) {
		return serviceService.saveAllService(services, findById(id));
	}

	@DeleteMapping
	public void deleteAllService(@RequestParam("serviceId") List<Integer> serviceId) {
		serviceService.deleteAllService(serviceId);
	}

	@GetMapping("/{serviceId}")
	public ServiceClass findByServiceId(@PathVariable("travelPackageId") int id,
			@PathVariable("serviceId") int serviceId) {
		return serviceService.findById(serviceId);
	}

	@PutMapping("/{serviceId}")
	public ServiceClass updateServices(@PathVariable("travelPackageId") int id,
			@PathVariable("serviceId") int serviceId, @RequestBody ServiceClass service) {
		service.setTravelPackage(findById(id));
		service.setServiceId(serviceId);
		return serviceService.saveService(service);
	}

	@DeleteMapping("/{serviceId}")
	public void deleteService(@PathVariable("travelPackageId") int id, @PathVariable("serviceId") int serviceId) {
		serviceService.deleteService(serviceId);
	}
}
