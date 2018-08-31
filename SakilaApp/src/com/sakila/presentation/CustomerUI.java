package com.sakila.presentation;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.sakila.beans.AddressBean;
import com.sakila.beans.CustomerBean;
import com.sakila.manager.CustomerManager;

public class CustomerUI {

	Logger logger = Logger.getLogger(CustomerUI.class);

	public void initializeMenu() {

		Scanner in = new Scanner(System.in);

		boolean isCorrect = false;
		int choice = 0;
		while (!isCorrect) {

			System.out.println("How do you want to search for CUSTOMER?");
			System.out.println("[1] By Customer First Name");
			System.out.println("[2] By Customer Last Name");
			System.out.println("[3] By Customer Country");
			System.out.println("Enter input [1-3]:");

			try {
				choice = Integer.parseInt(in.next());
				isCorrect = true;
			} catch (NumberFormatException nfe) {
				logger.error("NumberFormatExceptio occurred - input error: " + nfe.getMessage());
				System.out.println("Not a number! Please try again!");
			} catch (Exception e) {
				logger.error("Exception occured: " + e.getMessage());
				System.out.println("Error occurred. Please try again later!");
			}
		}

		System.out.println("*************************");
		System.out.println("Enter Search Parameter:");
		String answer = in.next();
		System.out.println("*************************");

		switch (choice) {
		case 1:
			searchbyFirstName(answer);
			break;
		case 2:
			searchByLastName(answer);
			break;
		case 3:
			searchByCountry(answer);
			break;
		default:
			System.out.println("Invalid Input.");
			System.out.println("*************************");
			break;
		}
	}

	public void printValues(Map<CustomerBean, AddressBean> hmap) {
		System.out.println("Search Result: ");
		for (Map.Entry<CustomerBean, AddressBean> map : hmap.entrySet()) {
			CustomerBean cust = map.getKey();
			AddressBean address = map.getValue();

			System.out.println("Customer First Name: " + cust.getFname());
			System.out.println("Customer Last Name: " + cust.getLname());
			System.out.println("Customer Email: " + cust.getEmail());
			System.out.println("Customer Address: " + address.getAddress() + ", " + address.getDistrict() + ", "
					+ address.getCity() + ", " + address.getCountry());
			System.out.println();
		}
	}

	public void searchbyFirstName(String param) {
		CustomerManager mng = new CustomerManager();
		try {
			printValues(mng.initializeValuesFirstName(param));
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException occurred - input file not found: " + e.getMessage());
			System.out.println("File not found! Please try again later.");
		} catch (Exception e) {
			logger.error("Exception occured: " + e.getMessage());
			System.out.println("Error occurred. Please try again later!");
		}
	}

	public void searchByLastName(String param) {
		CustomerManager mng = new CustomerManager();
		try {
			printValues(mng.initializeValuesLastName(param));
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException occurred - input file not found: " + e.getMessage());
			System.out.println("File not found! Please try again later.");
		} catch (Exception e) {
			logger.error("Exception occured: " + e.getMessage());
			System.out.println("Error occurred. Please try again later!");
		}
	}

	public void searchByCountry(String param) {
		CustomerManager mng = new CustomerManager();
		try {
			printValues(mng.initializeValuesCountry(param));
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException occurred - input file not found: " + e.getMessage());
			System.out.println("File not found! Please try again later.");
		} catch (Exception e) {
			logger.error("Exception occured: " + e.getMessage());
			System.out.println("Error occurred. Please try again later!");
		}
	}
}
