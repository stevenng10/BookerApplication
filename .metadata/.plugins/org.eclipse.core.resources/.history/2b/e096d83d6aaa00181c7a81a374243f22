package com.pw.io.booker.repository.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pw.io.booker.model.TravelItem;

public class TravelItemRepositoryMap {

	private Map<Integer, TravelItem> serviceMap = new HashMap<>();
	private int serviceIdGenerator = 1000;

	
	public List<TravelItem> findAll() {
		return new ArrayList<>(serviceMap.values());
	}

	
	public TravelItem find(int id) {
		return serviceMap.get(id);
	}

	
	public TravelItem save(TravelItem model) {
		if (find(model.getItemId()) != null) {
			serviceMap.put(model.getItemId(), model);
			return model;
		}
		model.setItemId(serviceIdGenerator++);
		serviceMap.put(model.getItemId(), model);
		return model;
	}

	
	public TravelItem delete(TravelItem model) {
		return serviceMap.remove(model.getItemId());
	}

}
