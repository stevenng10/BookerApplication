package com.booker.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.booker.app.model.Customer;
import com.booker.app.model.Reservation;
import com.booker.app.repository.CustomerRepository;

@Service("cs")
public class CustomerService {

	private CustomerRepository customerRepository;
	private ReservationService reservationService;

	public CustomerService(CustomerRepository customerRepository, ReservationService reservationService) {
		super();
		this.customerRepository = customerRepository;
		this.reservationService = reservationService;
	}

	public Customer findById(int id) {
		return customerRepository.findById(id).get();
	}

	public List<Customer> findAll() {
		return (List<Customer>) customerRepository.findAll();
	}

	@Transactional
	public Customer saveCustomer(Customer customer) {
		if (customer.getReservation() == null) {
			return customerRepository.save(customer);
		} else {
			reservationService.saveAllReservation((List<Reservation>) customer.getReservation());
			return customerRepository.save(customer);
		}
	}

	@Transactional
	public List<Customer> saveAllCustomer(List<Customer> customers) {
		for (Customer customer : customers) {
			if (customer.getReservation() == null) {
				customerRepository.save(customer);
			} else {
				reservationService.saveAllReservation((List<Reservation>) customer.getReservation());
				customerRepository.save(customer);
			}
		}
		return customers;
	}

	public void deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
	}

	public void deleteAllCustomer(List<Integer> ids) {
		List<Customer> customers = new ArrayList<>();
		Customer customer;
		for (Integer id : ids) {
			customer = findById(id);
			customers.add(customer);
		}
		customerRepository.deleteAll(customers);
	}

	public boolean doExist(int id) {
		return customerRepository.existsById(id);
	}
}