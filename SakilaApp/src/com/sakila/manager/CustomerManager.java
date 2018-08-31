package com.sakila.manager;

import java.util.Map;

import com.sakila.beans.AddressBean;
import com.sakila.beans.CustomerBean;
import com.sakila.repository.AddressDao;
import com.sakila.repository.CustomerDao;

public class CustomerManager {

	public Map<CustomerBean, AddressBean> initializeValuesLastName(String param) throws Exception {
		AddressDao address = new AddressDao();
		CustomerDao cust = new CustomerDao();
		return address.matchCustomerToAddressId(cust.searchByLastName(param));
	}

	public Map<CustomerBean, AddressBean> initializeValuesFirstName(String param) throws Exception {
		AddressDao address = new AddressDao();
		CustomerDao cust = new CustomerDao();
		return address.matchCustomerToAddressId(cust.searchByFirstName(param));
	}

	public Map<CustomerBean, AddressBean> initializeValuesCountry(String param) throws Exception {
		AddressDao address = new AddressDao();
		CustomerDao cust = new CustomerDao();
		return address.matchCustomerToAddressId(cust.matchAddressToCustomerId(address.searchByCountry(param)));
	}

}
