package com.sakila.main;

import com.sakila.presentation.FilmUI;
import com.sakila.presentation.LoginUI;

public class FilmMain {

	public static void main(String[] args) {

		LoginUI log = new LoginUI();
		boolean hasAccount = false;

		while (!hasAccount) {
			if (log.initializeMenu()) {
				hasAccount = true;
				FilmUI film = new FilmUI();
				film.initializeMenu();
			}
		}
	}

}
