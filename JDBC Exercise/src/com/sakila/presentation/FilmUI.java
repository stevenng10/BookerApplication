package com.sakila.presentation;

import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.sakila.beans.FilmBean;
import com.sakila.manager.FilmManager;

public class FilmUI {

	Logger logger = Logger.getLogger(FilmUI.class);

	public void initializeMenu() {

		Scanner in = new Scanner(System.in);

		boolean isCorrect = false;
		boolean isDone = false;
		int choice = 0;

		while (!isDone) {

			while (!isCorrect) {

				System.out.println("---------------- M E N U ---------------");
				System.out.println("[1] View All Films");
				System.out.println("[2] Add Film");
				System.out.println("[3] Search Film By ID");
				System.out.println("[4] Exit");
				System.out.println("Enter input [1-4]:");

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

			isCorrect = false;

			switch (choice) {
			case 1:
				viewAllFilms();
				break;
			case 2:
				addFilm();
				break;
			case 3:
				searchFilmById();
				break;
			case 4:
				System.out.println("Wala na finish na!");
				isDone = true;
				break;
			default:
				System.out.println("Invalid Input.");
				System.out.println("*************************");
				break;
			}
		}
	}

	public void viewAllFilms() {
		FilmManager mng = new FilmManager();

		try {
			for (FilmBean film : mng.viewAllFilms()) {
				System.out.println("Film Title: " + film.getTitle());
				System.out.println("Film Genre: " + film.getGenre());
				System.out.println("Film Description: " + film.getDescription());
				System.out.println("Film Rating: " + film.getRating());
				System.out.println("Film Special Features: " + film.getSpecialFeatures());
				System.out.println("Film Rental Rate: " + film.getRentalRate());
				System.out.println("*************************");
			}
		} catch (SQLException e) {
			logger.error("SQLException occurred - databse connection not found: " + e.getMessage());
			System.out.println("Databse connection not found! Please try again!");
		} catch (Exception e) {
			logger.error("Exception occured: " + e.getMessage());
			System.out.println("Error! Please try again!");
		}
	}

	public void addFilm() {

		Scanner in = new Scanner(System.in);
		FilmManager mng = new FilmManager();
		FilmBean film = new FilmBean();
		boolean isCorrectInt = false;
		boolean isCorrectDouble = false;
		double rent = 0;
		int id = 0;

		System.out.println("Adding Film:");
		System.out.println("*****************************");

		while (!isCorrectInt) {
			try {
				System.out.println("Film ID: ");
				id = Integer.parseInt(in.nextLine());
				isCorrectInt = true;
			} catch (NumberFormatException nfe) {
				logger.error("NumberFormatExceptio occurred - input error: " + nfe.getMessage());
				System.out.println("Not a number! Please try again!");
			} catch (Exception e) {
				logger.error("Exception occured: " + e.getMessage());
				System.out.println("Error occurred. Please try again later!");
			}
		}

		System.out.println("Film Title: ");
		String title = in.nextLine();
		System.out.println("Film Genre: ");
		String genre = in.nextLine();
		System.out.println("Film Description: ");
		String desc = in.nextLine();
		System.out.println("Film Rating: ");
		String rating = in.nextLine();
		System.out.println("Film Special Features: ");
		String spec = in.nextLine();

		while (!isCorrectDouble) {
			try {
				System.out.println("Film Rental Rate");
				rent = Double.parseDouble(in.next());
				isCorrectDouble = true;
			} catch (NumberFormatException nfe) {
				logger.error("NumberFormatExceptio occurred - input error: " + nfe.getMessage());
				System.out.println("Not a number! Please try again!");
			} catch (Exception e) {
				logger.error("Exception occured: " + e.getMessage());
				System.out.println("Error occurred. Please try again later!");
			}
		}

		film.setFilmId(id);
		film.setTitle(title);
		film.setGenre(genre);
		film.setDescription(desc);
		film.setRating(rating);
		film.setSpecialFeatures(spec);
		film.setRentalRate(rent);

		try {
			if (mng.addFilm(film) >= 1) {
				System.out.println("Film was added successfully!");
			} else {
				System.out.println("Film was not added successfully!");
			}
		} catch (SQLException e) {
			logger.error("SQLException occurred - databse connection not found: " + e.getMessage());
			System.out.println("Databse connection not found! Please try again!");
		} catch (Exception e) {
			logger.error("Exception occured: " + e.getMessage());
			System.out.println("Error! Please try again!");
		}
	}

	public void searchFilmById() {

		Scanner in = new Scanner(System.in);
		int id = 0;
		boolean isCorrect = false;
		boolean isFound;
		FilmManager mng = new FilmManager();

		while (!isCorrect) {
			try {
				System.out.println("Film ID: ");
				id = Integer.parseInt(in.nextLine());
				isCorrect = true;
			} catch (NumberFormatException nfe) {
				logger.error("NumberFormatExceptio occurred - input error: " + nfe.getMessage());
				System.out.println("Not a number! Please try again!");
			} catch (Exception e) {
				logger.error("Exception occured: " + e.getMessage());
				System.out.println("Error occurred. Please try again!");
			}
		}

		try {

			FilmBean film = mng.searchById(id);

			System.out.println("Film Title: " + film.getTitle());
			System.out.println("Film Genre: " + film.getGenre());
			System.out.println("Film Description: " + film.getDescription());
			System.out.println("Film Rating: " + film.getRating());
			System.out.println("Film Special Features: " + film.getSpecialFeatures());
			System.out.println("Film Rental Rate: " + film.getRentalRate());
			System.out.println("*************************");
			isFound = true;
		} catch (SQLException e) {
			logger.error("SQLException occurred - databse connection not found: " + e.getMessage());
			System.out.println("Databse connection not found! Please try again!");
			isFound = false;
		} catch (Exception e) {
			logger.error("Exception occured: " + e.getMessage());
			System.out.println("The id you entered was not found!");
			isFound = false;
		}

		if (isFound) {
			searchExtensionMenu(id);
		} else {
			System.out.println("The id you entered was not found!");
		}
	}

	public void searchExtensionMenu(int id) {

		boolean isCorrect = false;
		boolean isDone = false;
		int choice = 0;
		Scanner in = new Scanner(System.in);

		while (!isDone) {

			while (!isCorrect) {

				System.out.println("---------------- M E N U ---------------?");
				System.out.println("[1] Update Details");
				System.out.println("[2] Delete");
				System.out.println("[3] Nothing, just get me back to the main menu");
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

			switch (choice) {
			case 1:
				updateDetails(id);
				isDone = true;
				break;
			case 2:
				deleteFilmRecord(id);
				isDone = true;
				break;
			case 3:
				isDone = true;
				break;
			default:
				System.out.println("Invalid Input.");
				System.out.println("*************************");
				break;
			}
		}
	}

	public void updateDetails(int id) {

		Scanner in = new Scanner(System.in);
		FilmManager mng = new FilmManager();
		FilmBean film = new FilmBean();
		boolean isCorrect = false;
		double rent = 0;

		System.out.println("Updating Film:");
		System.out.println("*****************************");

		System.out.println("Film Title: ");
		String title = in.nextLine();
		System.out.println("Film Genre: ");
		String genre = in.nextLine();
		System.out.println("Film Description: ");
		String desc = in.nextLine();
		System.out.println("Film Rating: ");
		String rating = in.nextLine();
		System.out.println("Film Special Features: ");
		String spec = in.nextLine();

		while (!isCorrect) {
			try {
				System.out.println("Film Rental Rate");
				rent = Double.parseDouble(in.next());
				isCorrect = true;
			} catch (NumberFormatException nfe) {
				logger.error("NumberFormatExceptio occurred - input error: " + nfe.getMessage());
				System.out.println("Not a number! Please try again!");
			} catch (Exception e) {
				logger.error("Exception occured: " + e.getMessage());
				System.out.println("Error occurred. Please try again later!");
			}
		}

		film.setFilmId(id);
		film.setTitle(title);
		film.setGenre(genre);
		film.setDescription(desc);
		film.setRating(rating);
		film.setSpecialFeatures(spec);
		film.setRentalRate(rent);

		try {
			if (mng.updateFilm(film) >= 1) {
				System.out.println("Film was updated successfully!");
			} else {
				System.out.println("Film was not updated successfully!");
			}
		} catch (SQLException e) {
			logger.error("SQLException occurred - databse connection not found: " + e.getMessage());
			System.out.println("Databse connection not found! Please try again!");
		} catch (Exception e) {
			logger.error("Exception occured: " + e.getMessage());
			System.out.println("Error! Please try again!");
		}
	}

	public void deleteFilmRecord(int id) {

		Scanner in = new Scanner(System.in);
		FilmManager mng = new FilmManager();

		System.out.println("Are you sure you want to delete film id " + id + "?(Y/N)");
		String answer = in.nextLine().toUpperCase();

		if (answer.equals("Y") || answer.equals("YES")) {
			try {
				if (mng.deleteFilm(id) >= 1) {
					System.out.println("Film was deleted successfully!");
				} else {
					System.out.println("Film was not deleted successfully!");
				}
			} catch (SQLException e) {
				logger.error("SQLException occurred - databse connection not found: " + e.getMessage());
				System.out.println("Databse connection not found! Please try again!");
			} catch (Exception e) {
				logger.error("Exception occured: " + e.getMessage());
				System.out.println("Error! Please try again!");
			}
		} else {
			searchExtensionMenu(id);
		}
	}
}
