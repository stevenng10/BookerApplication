package com.pw.io.booker.repository.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pw.io.booker.model.TravelService;

@Repository
public class ServiceRepositoryList {

	private List<TravelService> serviceList = new ArrayList<>();
	private int serviceIdGenerator = 1000;

	public List<TravelService> findAll() {
		return serviceList;
	}

	public TravelService find(int id) {
		for (TravelService service : serviceList) {
			if (id == service.getServiceId()) {
				return service;
			}
		}
		return null;
	}

	public TravelService save(TravelService model) {
		if (find(model.getServiceId()) != null) {
			serviceList.add(model);
		}
		model.setServiceId(serviceIdGenerator++);
		serviceList.add(model);
		return model;
	}

	public TravelService delete(TravelService model) {
		for (Iterator<TravelService> iter = serviceList.iterator(); iter.hasNext();) {
			TravelService service = iter.next();
			if (model.getServiceId() == service.getServiceId()) {
				iter.remove();
				return service;
			}
		}
		return null;
	}

}
