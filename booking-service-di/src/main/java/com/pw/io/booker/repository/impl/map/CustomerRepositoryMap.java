package com.pw.io.booker.repository.impl.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pw.io.booker.model.Customer;
import com.pw.io.booker.repository.CustomerRepository;

@Repository
public class CustomerRepositoryMap implements CustomerRepository {
	
	private Map<Integer, Customer> customerMap = new HashMap<>();
	private int customerIdGenerator = 1000;
	
	@Override
	public List<Customer> findAll() {
		return new ArrayList<>(customerMap.values());
	}

	@Override
	public Customer findById(int id) {
		return customerMap.get(id);
	}

	@Override
	public Customer save(Customer model) {
		if(findById(model.getCustomerId()) != null) {			
			customerMap.put(model.getCustomerId(), model);
			return model;
		}
		model.setCustomerId(customerIdGenerator++);
		customerMap.put(model.getCustomerId(), model);
		return model;	
	}

	@Override
	public void delete(Customer model) {
		customerMap.remove(model.getCustomerId());
	}

}
