package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@GetMapping
	public Iterable<Customer> getAllCustomers() {
		return customerService.findAll();
	}

	@PostMapping
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}

	@PutMapping("/{id}")
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable("id") int id) {
		customer.setCustomerId(id);
		return customerService.saveCustomer(customer);
	}

	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable("id") int id) {
		customerService.deleteCustomer(customerService.findById(id));
	}

	@GetMapping("/{id}")
	public Customer findCustomer(@PathVariable("id") int id) {
		return customerService.findById(id);
	}
}