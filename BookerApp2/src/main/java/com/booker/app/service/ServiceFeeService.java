package com.booker.app.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.booker.app.model.ServiceClass;
import com.booker.app.model.ServiceFee;
import com.booker.app.repository.ServiceFeeRepository;

public class ServiceFeeService {
	private ServiceFeeRepository serviceFeeRepository;

	public ServiceFeeService(ServiceFeeRepository serviceFeeRepository) {
		super();
		this.serviceFeeRepository = serviceFeeRepository;
	}

	public ServiceFee findById(int id) {
		return serviceFeeRepository.findById(id).get();
	}

	public List<ServiceFee> findAll() {
		return (List<ServiceFee>) serviceFeeRepository.findAll();
	}

	@Transactional
	public List<ServiceFee> saveAllServiceFee(List<ServiceFee> serviceFees, ServiceClass service) {
		for (ServiceFee serviceFee : serviceFees) {
			serviceFee.setService(service);
		}
		return (List<ServiceFee>) serviceFeeRepository.saveAll(serviceFees);
	}

	public void deleteServiceFee(ServiceFee serviceFee) {
		serviceFeeRepository.delete(serviceFee);
	}
}
