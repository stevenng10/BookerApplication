package com.animalshelter.presentation;

import java.util.Scanner;

import com.animalshelter.manager.AnimalShelterManager;

public class HomePage {

	public int initializeMenu() {

		Scanner in = new Scanner(System.in);
		AnimalShelterManager mng = new AnimalShelterManager();
		int choice = 0;

		if (mng.isCatFull() && mng.isDogFull() && mng.isParrotFull()) {
			System.out.println("The animal shelter is currently full. Thank you!");
		} else {
			System.out.println("Welcome to Steven's Animal Shelter!");
			System.out.println("What shelter would you like to visit? Please select an option: ");
			System.out.println("[1] Dog Sheler");
			System.out.println("[2] Cat Sheler");
			System.out.println("[3] Parrot Sheler");

			boolean isCorrect = false;
			while (!isCorrect) {
				try {
					System.out.println("Enter Choice: ");
					choice = in.nextInt();
					isCorrect = true;
				} catch (Exception e) {
					break;
				}
			}
		}

		return choice;
	}
}
