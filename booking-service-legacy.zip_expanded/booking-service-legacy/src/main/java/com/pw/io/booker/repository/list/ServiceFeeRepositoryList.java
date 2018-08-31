package com.pw.io.booker.repository.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pw.io.booker.model.ServiceFee;

public class ServiceFeeRepositoryList {

	private List<ServiceFee> serviceFeeList = new ArrayList<>();
	private int serviceFeeIdGenerator = 1000;

	public List<ServiceFee> findAll() {
		return serviceFeeList;
	}

	public ServiceFee find(int id) {
		for (ServiceFee serviceFee : serviceFeeList) {
			if (id == serviceFee.getServiceFeeId()) {
				return serviceFee;
			}
		}
		return null;
	}

	public ServiceFee save(ServiceFee model) {
		if (find(model.getServiceFeeId()) != null) {
			serviceFeeList.add(model);
		}
		model.setServiceFeeId(serviceFeeIdGenerator++);
		serviceFeeList.add(model);
		return model;
	}

	public ServiceFee delete(ServiceFee model) {
		for (Iterator<ServiceFee> iter = serviceFeeList.iterator(); iter.hasNext();) {
			ServiceFee serviceFee = iter.next();
			if (model.getServiceFeeId() == serviceFee.getServiceFeeId()) {
				iter.remove();
				return serviceFee;
			}
		}
		return null;
	}

}
