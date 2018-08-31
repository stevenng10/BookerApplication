package com.sakila.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.sakila.beans.AddressBean;
import com.sakila.beans.CustomerBean;

public class CustomerDao {

	Logger logger = Logger.getLogger(CustomerDao.class);

	public List<CustomerBean> searchByFirstName(String param) throws Exception {
		File inputFile = new File("customer-table.txt");
		Scanner in;

		List<CustomerBean> custs = new ArrayList<>();
		CustomerBean cust;
		String[] custLineDetails;

		try {
			in = new Scanner(inputFile);
			String nxtln = in.nextLine();
			while (in.hasNext()) {
				custLineDetails = in.nextLine().split("\\|");
				if (custLineDetails[2].toLowerCase().indexOf(param) != -1) {
					cust = new CustomerBean();

					cust.setCustId(custLineDetails[0]);
					cust.setStoreId(custLineDetails[1]);
					cust.setFname(custLineDetails[2]);
					cust.setLname(custLineDetails[3]);
					cust.setEmail(custLineDetails[4]);
					cust.setAddressId(custLineDetails[5]);

					custs.add(cust);
				}
			}
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException occurred - input file not found: " + e.getMessage());
			throw new FileNotFoundException("File not found.");
		} catch (Exception e) {
			logger.error("Exception occured: " + e.getMessage());
			throw new Exception("Error occurred. Please try again later...");
		}
		return custs;
	}

	public List<CustomerBean> searchByLastName(String param) throws Exception {
		File inputFile = new File("customer-table.txt");
		Scanner in;

		List<CustomerBean> custs = new ArrayList<>();
		CustomerBean cust;
		String[] custLineDetails;

		try {
			in = new Scanner(inputFile);
			String nxtln = in.nextLine();
			while (in.hasNext()) {
				custLineDetails = in.nextLine().split("\\|");
				if (custLineDetails[3].toLowerCase().indexOf(param) != -1) {
					cust = new CustomerBean();

					cust.setCustId(custLineDetails[0]);
					cust.setStoreId(custLineDetails[1]);
					cust.setFname(custLineDetails[2]);
					cust.setLname(custLineDetails[3]);
					cust.setEmail(custLineDetails[4]);
					cust.setAddressId(custLineDetails[5]);

					custs.add(cust);
				}
			}
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException occurred - input file not found: " + e.getMessage());
			throw new FileNotFoundException("File not found.");
		} catch (Exception e) {
			logger.error("Exception occured: " + e.getMessage());
			throw new Exception("Error occurred. Please try again later...");
		}
		return custs;
	}

	public List<CustomerBean> matchAddressToCustomerId(List<AddressBean> addresses) throws Exception {
		File inputFile = new File("customer-table.txt");
		Scanner in;

		Map<String, List<String>> hmap = new HashMap<>();
		CustomerBean cust;
		List<CustomerBean> custs = new ArrayList<>();

		String[] custLineDetails;

		try {
			in = new Scanner(inputFile);
			String nxtln = in.nextLine();
			while (in.hasNext()) {
				custLineDetails = in.nextLine().split("\\|");

				for (int j = 0; j < addresses.size(); j++) {
					if (custLineDetails[5].equals(addresses.get(j).getAddressId())) {
						cust = new CustomerBean();

						cust.setCustId(custLineDetails[0]);
						cust.setStoreId(custLineDetails[1]);
						cust.setFname(custLineDetails[2]);
						cust.setLname(custLineDetails[3]);
						cust.setEmail(custLineDetails[4]);
						cust.setAddressId(custLineDetails[5]);

						custs.add(cust);
					}
				}
			}

		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException occurred - input file not found: " + e.getMessage());
			throw new FileNotFoundException("File not found.");
		} catch (Exception e) {
			logger.error("Exception occured: " + e.getMessage());
			throw new Exception("Error occurred. Please try again later...");
		}
		return custs;
	}
}
