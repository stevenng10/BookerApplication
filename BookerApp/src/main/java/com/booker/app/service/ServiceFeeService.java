package com.booker.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.booker.app.model.ServiceFee;
import com.booker.app.repository.ServiceFeeRepository;

@Service
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
	public ServiceFee saveServiceFee(ServiceFee serviceFee) {
		return serviceFeeRepository.save(serviceFee);
	}

	public void deleteServiceFee(ServiceFee serviceFee) {
		serviceFeeRepository.delete(serviceFee);
	}
}
