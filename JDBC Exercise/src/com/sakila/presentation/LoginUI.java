package com.sakila.presentation;

import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.sakila.beans.LoginBean;
import com.sakila.manager.LoginManager;

public class LoginUI {

	Logger logger = Logger.getLogger(LoginUI.class);

	public boolean initializeMenu() {

		Scanner in = new Scanner(System.in);
		LoginManager mng = new LoginManager();
		LoginBean log = new LoginBean();

		System.out.println("Enter your username: ");
		String username = in.nextLine();
		System.out.println("Enter your password: ");
		String password = in.nextLine();

		log.setUsername(username);
		log.setPassword(password);

		boolean isFound = false;

		try {
			if (mng.checkLoginCredentials(log)) {
				isFound = true;
				System.out.println("Hi " + username);
			} else {
				System.out.println("Invalid username or password!");
			}
		} catch (SQLException e) {
			logger.error("SQLException occurred - databse connection not found: " + e.getMessage());
			System.out.println("Databse connection not found! Please try again!");
		} catch (Exception e) {
			logger.error("Exception occured: " + e.getMessage());
			System.out.println("Username or password not found!");
		}
		return isFound;
	}
}
