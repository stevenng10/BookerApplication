package com.sakila.presentation;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class HomePage {

	Logger logger = Logger.getLogger(HomePage.class);

	public int initializeMenu() {

		Scanner in = new Scanner(System.in);

		boolean isCorrect = false;
		int choice = 0;
		while (!isCorrect) {

			System.out.println("What do you want to search for?");
			System.out.println("[1] Films");
			System.out.println("[2] Actors");
			System.out.println("[3] Customers");
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

		return choice;
	}
}
