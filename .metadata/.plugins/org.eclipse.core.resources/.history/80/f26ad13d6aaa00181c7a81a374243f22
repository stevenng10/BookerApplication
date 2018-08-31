package com.pw.io.booker.repository.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pw.io.booker.model.Customer;

public class CustomerRepositoryMap  {
	
	private Map<Integer, Customer> customerMap = new HashMap<>();
	private int customerIdGenerator = 1000;
	
	
	public List<Customer> findAll() {
		return new ArrayList<>(customerMap.values());
	}

	
	public Customer find(int id) {
		return customerMap.get(id);
	}

	
	public Customer save(Customer model) {
		if(find(model.getCustomerId()) != null) {			
			customerMap.put(model.getCustomerId(), model);
			return model;
		}
		model.setCustomerId(customerIdGenerator++);
		customerMap.put(model.getCustomerId(), model);
		return model;	
	}

	
	public Customer delete(Customer model) {
		return customerMap.remove(model.getCustomerId());
	}

}
