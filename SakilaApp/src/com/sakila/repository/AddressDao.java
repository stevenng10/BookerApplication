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

public class AddressDao {

	Logger logger = Logger.getLogger(AddressDao.class);

	public Map<CustomerBean, AddressBean> matchCustomerToAddressId(List<CustomerBean> custs) throws Exception {
		File inputFile = new File("address-table.txt");
		Scanner in;

		Map<CustomerBean, AddressBean> hmap = new HashMap<>();
		AddressBean address;
		CustomerBean cust;

		String[] addressDetails;

		try {
			in = new Scanner(inputFile);
			String nxtln = in.nextLine();
			while (in.hasNext()) {
				addressDetails = in.nextLine().split("\\|");

				for (int j = 0; j < custs.size(); j++) {
					if (addressDetails[0].equals(custs.get(j).getAddressId())) {

						cust = custs.get(j);

						address = new AddressBean();

						address.setAddressId(addressDetails[0]);
						address.setAddress(addressDetails[1]);
						address.setDistrict(addressDetails[2]);
						address.setCity(addressDetails[3]);
						address.setCountry(addressDetails[4]);

						hmap.put(cust, address);
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
		return hmap;
	}

	public List<AddressBean> searchByCountry(String param) throws Exception {
		File inputFile = new File("address-table.txt");
		Scanner in;

		List<AddressBean> addresses = new ArrayList<>();
		AddressBean address;
		String[] addressDetails;

		try {
			in = new Scanner(inputFile);
			String nxtln = in.nextLine();
			while (in.hasNext()) {
				addressDetails = in.nextLine().split("\\|");
				if (addressDetails[4].toLowerCase().indexOf(param) != -1) {
					address = new AddressBean();

					address.setAddressId(addressDetails[0]);
					address.setAddress(addressDetails[1]);
					address.setDistrict(addressDetails[2]);
					address.setCity(addressDetails[3]);
					address.setCountry(addressDetails[4]);

					addresses.add(address);
				}
			}
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException occurred - input file not found: " + e.getMessage());
			throw new FileNotFoundException("File not found.");
		} catch (Exception e) {
			logger.error("Exception occured: " + e.getMessage());
			throw new Exception("Error occurred. Please try again later...");
		}
		return addresses;
	}

}
