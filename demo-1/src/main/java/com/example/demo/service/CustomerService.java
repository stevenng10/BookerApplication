package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Customer;
import com.example.demo.model.Feedback;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {

	private CustomerRepository customerRepository;
	private FeedbackService feedbackService;

	public CustomerService(CustomerRepository customerRepository, FeedbackService feedbackService) {
		super();
		this.customerRepository = customerRepository;
		this.feedbackService = feedbackService;
	}

	public Customer findById(int id) {
		return customerRepository.findById(id).get();
	}

	public Iterable<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Transactional
	public Customer saveCustomer(Customer customer) {
		for (Feedback feedback : customer.getFeedback()) {
			feedback.setCustomer(customer);
			feedbackService.saveFeedback(feedback);
		}
		return customerRepository.save(customer);
	}

	public void deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
	}
}
