package com.pw.io.booker.repository.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pw.io.booker.model.TravelService;

public class ServiceRepositoryMap {

	private Map<Integer, TravelService> serviceMap = new HashMap<>();
	private int serviceIdGenerator = 1000;

	
	public List<TravelService> findAll() {
		return new ArrayList<>(serviceMap.values());
	}

	
	public TravelService find(int id) {
		return serviceMap.get(id);
	}

	
	public TravelService save(TravelService model) {
		if (find(model.getServiceId()) != null) {
			serviceMap.put(model.getServiceId(), model);
			return model;
		}
		model.setServiceId(serviceIdGenerator++);
		serviceMap.put(model.getServiceId(), model);
		return model;
	}

	
	public TravelService delete(TravelService model) {
		return serviceMap.remove(model.getServiceId());
	}

}
