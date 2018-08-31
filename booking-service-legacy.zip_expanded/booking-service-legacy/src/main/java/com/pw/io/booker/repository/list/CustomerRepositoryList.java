package com.pw.io.booker.repository.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pw.io.booker.model.Customer;

public class CustomerRepositoryList {

	private List<Customer> customerList = new ArrayList<>();
	private int customerIdGenerator = 1000;

	public List<Customer> findAll() {
		return customerList;
	}

	public Customer find(int id) {
		for (Customer customer : customerList) {
			if (id == customer.getCustomerId()) {
				return customer;
			}
		}
		return null;
	}

	public Customer save(Customer model) {
		if (find(model.getCustomerId()) != null) {
			customerList.add(model);
		}
		model.setCustomerId(customerIdGenerator++);
		customerList.add(model);
		return model;
	}

	public Customer delete(Customer model) {
		for (Iterator<Customer> iter = customerList.iterator(); iter.hasNext();) {
			Customer customer = iter.next();
			if (model.getCustomerId() == customer.getCustomerId()) {
				iter.remove();
				return customer;
			}
		}
		return null;
	}

}
