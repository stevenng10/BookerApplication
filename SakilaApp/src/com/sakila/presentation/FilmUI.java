package com.sakila.presentation;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.sakila.beans.FilmActorBean;
import com.sakila.manager.FilmManager;

public class FilmUI {

	Logger logger = Logger.getLogger(FilmUI.class);

	public void initializeMenu() {

		Scanner in = new Scanner(System.in);

		boolean isCorrect = false;
		int choice = 0;
		while (!isCorrect) {

			System.out.println("How do you want to search for FILMS?");
			System.out.println("[1] By Title");
			System.out.println("[2] By Genre/Category");
			System.out.println("[3] By Actor Last Name");
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
			searchByTitle(answer);
			break;
		case 2:
			searchByGenre(answer);
			break;
		case 3:
			searchByLastName(answer);
			break;
		default:
			System.out.println("Invalid Input.");
			System.out.println("*************************");
			break;
		}
	}

	public void printValues(List<FilmActorBean> filmActors) {

		System.out.println("Search Results: ");
		for (int i = 0; i < filmActors.size(); i++) {
			System.out.println("File Title: " + filmActors.get(i).getFilm().getTitle());
			System.out.println("File Genre: " + filmActors.get(i).getFilm().getGenre());
			System.out.println("File Description: " + filmActors.get(i).getFilm().getDescription());
			System.out.println("File Rating: " + filmActors.get(i).getFilm().getRating());
			System.out.println("File Special Features: " + filmActors.get(i).getFilm().getSpecialFeatures());
			System.out.println("Starring:");
			for (int j = 0; j < filmActors.get(i).getActor().size(); j++) {
				System.out.println("*    " + filmActors.get(i).getActor().get(j).getLname() + ", "
						+ filmActors.get(i).getActor().get(j).getFname());
			}
			System.out.println();
		}
	}

	public void searchByTitle(String param) {

		FilmManager mng = new FilmManager();
		try {
			printValues(mng.initializeValuesTitle(param));
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException occurred - input file not found: " + e.getMessage());
			System.out.println("File not found! Please try again later.");
		} catch (Exception e) {
			logger.error("Exception occured: " + e.getMessage());
			System.out.println("Error occurred. Please try again later!");
		}
	}

	public void searchByGenre(String param) {

		FilmManager mng = new FilmManager();
		try {
			printValues(mng.initializeValuesGenre(param));
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException occurred - input file not found: " + e.getMessage());
			System.out.println("File not found! Please try again later.");
		} catch (Exception e) {
			logger.error("Exception occured: " + e.getMessage());
			System.out.println("Error occurred. Please try again later!");
		}
	}

	public void searchByLastName(String param) {

		FilmManager mng = new FilmManager();
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
}
