package com.sakila.presentation;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.sakila.beans.ActorFilmBean;
import com.sakila.manager.ActorManager;

public class ActorUI {

	Logger logger = Logger.getLogger(ActorUI.class);

	public void initializeMenu() {

		Scanner in = new Scanner(System.in);

		boolean isCorrect = false;
		int choice = 0;
		while (!isCorrect) {

			System.out.println("How do you want to search for ACTORS?");
			System.out.println("[1] By Actor First Name");
			System.out.println("[2] By Actor Last Name");
			System.out.println("Enter input [1-2]:");

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
			searchByFirstName(answer);
			break;
		case 2:
			searchByLastName(answer);
			break;
		default:
			System.out.println("Invalid Input.");
			System.out.println("*************************");
			break;
		}
	}

	public void printValues(List<ActorFilmBean> filmActors) {

		System.out.println("Search Results: ");
		for (int i = 0; i < filmActors.size(); i++) {
			System.out
					.println(filmActors.get(i).getActor().getLname() + ", " + filmActors.get(i).getActor().getFname());
			System.out.println("Starred in:");
			for (int j = 0; j < filmActors.get(i).getFilm().size(); j++) {
				System.out.println("*    " + filmActors.get(i).getFilm().get(j).getTitle());
			}
			System.out.println();
		}
	}

	public void searchByFirstName(String param) {
		ActorManager mng = new ActorManager();
		List<ActorFilmBean> filmActors;
		try {
			filmActors = mng.initializeValuesFirstName(param);
			printValues(filmActors);
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException occurred - input file not found: " + e.getMessage());
			System.out.println("File not found! Please try again later.");
		} catch (Exception e) {
			logger.error("Exception occured: " + e.getMessage());
			System.out.println("Error occurred. Please try again later!");
		}
	}

	public void searchByLastName(String param) {
		ActorManager mng = new ActorManager();
		List<ActorFilmBean> filmActors;
		try {
			filmActors = mng.initializeValuesLastName(param);
			printValues(filmActors);
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException occurred - input file not found: " + e.getMessage());
			System.out.println("File not found! Please try again later.");
		} catch (Exception e) {
			logger.error("Exception occured: " + e.getMessage());
			System.out.println("Error occurred. Please try again later!");
		}
	}
}
