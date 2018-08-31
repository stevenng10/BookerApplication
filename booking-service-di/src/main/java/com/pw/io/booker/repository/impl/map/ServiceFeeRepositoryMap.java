package com.pw.io.booker.repository.impl.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pw.io.booker.model.ServiceFee;
import com.pw.io.booker.repository.ServiceFeeRepository;

@Repository
public class ServiceFeeRepositoryMap implements ServiceFeeRepository {

	private Map<Integer, ServiceFee> serviceFeeMap = new HashMap<>();
	private int serviceFeeIdGenerator = 1000;
	
	@Override
	public List<ServiceFee> findAll() {
		return new ArrayList<>(serviceFeeMap.values());
	}

	@Override
	public ServiceFee findById(int id) {
		return serviceFeeMap.get(id);
	}

	@Override
	public ServiceFee save(ServiceFee model) {
		if(findById(model.getServiceFeeId()) != null) {			
			serviceFeeMap.put(model.getServiceFeeId(), model);
			return model;
		}
		model.setServiceFeeId(serviceFeeIdGenerator++);
		serviceFeeMap.put(model.getServiceFeeId(), model);
		return model;	
	}

	@Override
	public void delete(ServiceFee model) {
		serviceFeeMap.remove(model.getServiceFeeId());
	}

}
