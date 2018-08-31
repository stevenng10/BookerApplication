package com.pw.travelagency.bookingservice;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pw.io.booker.model.Customer;
import com.pw.io.booker.repository.CustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:com/pw/travelagency/booking/booking-context.xml"})
public class BookingServiceApplicationXMLConfigTests {
	
	@Autowired
	private CustomerRepository customerRepositoryMap;
	
	@Test
	public void testCustomerRepositorySaves() {
		Customer customer = customerRepositoryMap.save(new Customer());
		assertEquals(customer.getCustomerId(), 
				customerRepositoryMap.findById(customer.getCustomerId()));
	}
}
