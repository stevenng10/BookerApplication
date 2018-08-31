package com.sakila.main;

import com.sakila.presentation.ActorUI;
import com.sakila.presentation.CustomerUI;
import com.sakila.presentation.FilmUI;
import com.sakila.presentation.HomePage;

public class FilmMain {

	public static void main(String[] args) {

		boolean isCorrect = false;
		HomePage home = new HomePage();

		while (!isCorrect) {
			switch (home.initializeMenu()) {
			case 1:
				FilmUI film = new FilmUI();
				film.initializeMenu();
				break;
			case 2:
				ActorUI actor = new ActorUI();
				actor.initializeMenu();
				break;
			case 3:
				CustomerUI cust = new CustomerUI();
				cust.initializeMenu();
				break;
			default:
				System.out.println("Invalid Input!");
			}
		}
	}

}
