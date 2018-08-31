package com.booker.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booker.app.model.Customer;
import com.booker.app.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@GetMapping
	public List<Customer> getAllCustomers() {
		return customerService.findAll();
	}

	@GetMapping("/{id}")
	public Customer findCustomer(@PathVariable("id") int id) {
		return customerService.findById(id);
	}

	@PostMapping
	public List<Customer> saveCustomer(@RequestBody List<Customer> customers) {
		return customerService.saveAllCustomer(customers);
	}

	@PutMapping
	public List<Customer> updateAllCustomer(@RequestBody List<Customer> customers) {
		return customerService.saveAllCustomer(customers);
	}

	@PutMapping("/{id}")
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable("id") int id) {
		customer.setCustomerId(id);
		return customerService.saveCustomer(customer);
	}

	@DeleteMapping("/{id}")
	public void deleteCustomerSpecific(@PathVariable("id") int id) {
		customerService.deleteCustomer(customerService.findById(id));
	}

	@DeleteMapping
	public void deleteCustomerList(@RequestParam("id") List<Integer> id) {
		customerService.deleteAllCustomer(id);
	}
}
