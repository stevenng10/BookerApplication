package com.booker.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booker.app.model.ServiceClass;
import com.booker.app.model.ServiceFee;
import com.booker.app.service.ServiceFeeService;
import com.booker.app.service.ServiceService;

@RestController
@RequestMapping("/servicefee/{serviceId}")
public class ServiceeFeeController {

	private ServiceFeeService serviceFeeService;
	private ServiceService serviceService;

	public ServiceeFeeController(ServiceFeeService serviceFeeService, ServiceService serviceService) {
		super();
		this.serviceFeeService = serviceFeeService;
		this.serviceService = serviceService;
	}

	@GetMapping
	public ServiceClass findByServiceId(@PathVariable("serviceId") int serviceId) {
		return serviceService.findById(serviceId);
	}

	@PostMapping
	public List<ServiceFee> insertServiceFee(@PathVariable("serviceId") int serviceId,
			@RequestBody List<ServiceFee> serviceFees) {
		return serviceFeeService.saveAllServiceFee(serviceFees, findByServiceId(serviceId));
	}
}
