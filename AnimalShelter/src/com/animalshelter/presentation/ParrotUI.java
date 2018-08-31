package com.animalshelter.presentation;

import java.util.Scanner;

import com.animalshelter.beans.InputBeans;
import com.animalshelter.manager.AnimalShelterManager;
import com.animalshelter.manager.ParrotManager;

public class ParrotUI {

	ParrotManager parrot = new ParrotManager();
	AnimalShelterManager mng = new AnimalShelterManager();

	public void initializeParrotMenu() {

		Scanner in = new Scanner(System.in);
		boolean isCorrect = false;

		while (!isCorrect) {

			System.out.println("Welcome to Parrot Shelter!");
			System.out.println("Please select an option:");

			if (mng.countParrots() == 0) {
				System.out.println("[1] Add a Parrot");
				System.out.println("[2] Go back to Home Page");
			} else if (mng.countParrots() > 0 && mng.countParrots() < 5) {
				System.out.println("[1] Add a parrot");
				System.out.println("[2] Remove a Parrot");
				System.out.println("[3] View all Parrots");
				System.out.println("[4] Feed Parrots");
				System.out.println("[5] Go back to Home Page");
			} else {
				System.out.println("[1] Remove a Parrot");
				System.out.println("[2] View all Parrots");
				System.out.println("[3] Feed Parrots");
				System.out.println("[4] Go back to Home Page");
			}

			int choice = 0;

			boolean isRight = false;
			while (!isRight) {
				try {
					System.out.println("Enter choice:");
					choice = Integer.parseInt(in.nextLine());
					isRight = true;
				} catch (Exception e) {
					System.out.println("Invalid Input!");
					continue;
				}
			}

			if (mng.countParrots() == 0) {
				switch (choice) {
				case 1:
					addParrot();
					isCorrect = true;
					break;
				case 2:
					isCorrect = true;
					break;
				default:
					System.out.println("Invalid Input.");
					break;
				}
			} else if (mng.countParrots() > 0 && mng.countParrots() < 5) {
				switch (choice) {
				case 1:
					addParrot();
					isCorrect = true;
					break;
				case 2:
					removeParrot();
					isCorrect = false;
					continue;
				case 3:
					showParrots();
					isCorrect = false;
					continue;
				case 4:
					feedParrots();
					isCorrect = true;
					break;
				case 5:
					isCorrect = true;
					break;
				default:
					System.out.println("Invalid Input.");
					break;
				}
			} else {
				switch (choice) {
				case 1:
					removeParrot();
					isCorrect = false;
					continue;
				case 2:
					showParrots();
					isCorrect = false;
					continue;
				case 3:
					feedParrots();
					isCorrect = true;
					break;
				case 4:
					isCorrect = true;
					break;
				default:
					System.out.println("Invalid Input.");
					break;
				}
			}
		}

	}

	public void addParrot() {

		Scanner in = new Scanner(System.in);
		InputBeans bean;
		boolean isCorrect = false;

		System.out.println("Please give the parrot a name: ");
		String name = in.next();

		String gender = null;

		while (!isCorrect) {

			System.out.println("Please give the parrot a gender(M/F): ");
			gender = in.next().toUpperCase();

			if (gender.equals("M")) {
				gender = "Male";
				isCorrect = true;
			} else if (gender.equals("F")) {
				gender = "Female";
				isCorrect = true;
			}
		}

		int age = 0;

		boolean isRight = false;
		while (!isRight) {
			try {
				System.out.println("Please give the parrot an age: ");
				age = Integer.parseInt(in.next());
				isRight = true;
			} catch (Exception e) {
				System.out.println("Invalid Input!");
				continue;
			}
		}

		bean = new InputBeans(name, age, gender);

		if (parrot.addParrot(bean)) {
			System.out.println("Parrot is now added.");
		} else {
			System.out.println("Parrot shelter full!");
		}
	}

	public void removeParrot() {

		Scanner in = new Scanner(System.in);

		int id = 0;

		boolean isRight = false;
		while (!isRight) {
			try {
				System.out.println("Please enter the reference ID of the parrot to remove: ");
				id = Integer.parseInt(in.next());
				isRight = true;
			} catch (Exception e) {
				System.out.println("Invalid Input!");
				continue;
			}
		}

		if (parrot.removeParrot(id)) {
			System.out.println("Parrot has been successfully removed.");
		} else {
			System.out.println("Parrot has not been successfully removed or it was not found.");
		}
	}

	public void showParrots() {
		System.out.println(parrot.showParrots());
	}

	public void feedParrots() {

		Scanner in = new Scanner(System.in);
		int id = 0;

		boolean isRight = false;
		while (!isRight) {
			try {
				System.out.println("Please enter the reference ID of the parrot to feed: ");
				id = Integer.parseInt(in.next());
				isRight = true;
			} catch (Exception e) {
				System.out.println("Invalid Input!");
				continue;
			}
		}

		if (parrot.feedParrots(id)) {
			System.out.println(parrot.getName() + ": Yum yum deliciouso.");
		} else {
			System.out.println("Parrot has not been successfully feed or it was not found.");
		}
	}
}
