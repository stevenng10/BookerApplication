package com.pw.io.booker.repository.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pw.io.booker.model.ServiceFee;

public class ServiceFeeRepositoryMap {

	private Map<Integer, ServiceFee> serviceFeeMap = new HashMap<>();
	private int serviceFeeIdGenerator = 1000;
	
	
	public List<ServiceFee> findAll() {
		return new ArrayList<>(serviceFeeMap.values());
	}

	
	public ServiceFee find(int id) {
		return serviceFeeMap.get(id);
	}

	
	public ServiceFee save(ServiceFee model) {
		if(find(model.getServiceFeeId()) != null) {			
			serviceFeeMap.put(model.getServiceFeeId(), model);
			return model;
		}
		model.setServiceFeeId(serviceFeeIdGenerator++);
		serviceFeeMap.put(model.getServiceFeeId(), model);
		return model;	
	}

	
	public ServiceFee delete(ServiceFee model) {
		return serviceFeeMap.remove(model.getServiceFeeId());
	}

}
