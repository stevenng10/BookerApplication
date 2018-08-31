package com.animalshelter.presentation;

import java.util.Scanner;

import com.animalshelter.beans.InputBeans;
import com.animalshelter.manager.AnimalShelterManager;
import com.animalshelter.manager.CatManager;

public class CatUI {

	CatManager cat = new CatManager();
	AnimalShelterManager mng = new AnimalShelterManager();

	public void initializeCatMenu() {

		Scanner in = new Scanner(System.in);
		boolean isCorrect = false;

		while (!isCorrect) {

			System.out.println("Welcome to Cat Shelter!");
			System.out.println("Please select an option:");

			if (mng.countCats() == 0) {
				System.out.println("[1] Add a Cat");
				System.out.println("[2] Go back to Home Page");
			} else if (mng.countCats() > 0 && mng.countCats() < 5) {
				System.out.println("[1] Add a cat");
				System.out.println("[2] Remove a Cat");
				System.out.println("[3] View all Cats");
				System.out.println("[4] Feed Cats");
				System.out.println("[5] Go back to Home Page");
			} else {
				System.out.println("[1] Remove a Cat");
				System.out.println("[2] View all Cats");
				System.out.println("[3] Feed Cats");
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

			if (mng.countCats() == 0) {
				switch (choice) {
				case 1:
					addCat();
					isCorrect = true;
					break;
				case 2:
					isCorrect = true;
					break;
				default:
					System.out.println("Invalid Input.");
					break;
				}
			} else if (mng.countCats() > 0 && mng.countCats() < 5) {
				switch (choice) {
				case 1:
					addCat();
					isCorrect = true;
					break;
				case 2:
					removeCat();
					isCorrect = false;
					continue;
				case 3:
					showCats();
					isCorrect = false;
					continue;
				case 4:
					feedCats();
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
					removeCat();
					isCorrect = false;
					continue;
				case 2:
					showCats();
					isCorrect = false;
					continue;
				case 3:
					feedCats();
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

	public void addCat() {

		Scanner in = new Scanner(System.in);
		InputBeans bean;
		boolean isCorrect = false;

		System.out.println("Please give the cat a name: ");
		String name = in.next();

		String gender = null;

		while (!isCorrect) {

			System.out.println("Please give the cat a gender(M/F): ");
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
				System.out.println("Please give the cat an age: ");
				age = Integer.parseInt(in.next());
				isRight = true;
			} catch (Exception e) {
				System.out.println("Invalid Input!");
				continue;
			}
		}

		bean = new InputBeans(name, age, gender);

		if (cat.addCat(bean)) {
			System.out.println("Cat is now added.");
		} else {
			System.out.println("Cat shelter full!");
		}
	}

	public void removeCat() {

		Scanner in = new Scanner(System.in);

		int id = 0;

		boolean isRight = false;
		while (!isRight) {
			try {
				System.out.println("Please enter the reference ID of the cat to remove: ");
				id = Integer.parseInt(in.next());
				isRight = true;
			} catch (Exception e) {
				System.out.println("Invalid Input!");
				continue;
			}
		}

		if (cat.removeCat(id)) {
			System.out.println("Cat has been successfully removed.");
		} else {
			System.out.println("Cat has not been successfully removed or it was not found.");
		}
	}

	public void showCats() {
		System.out.println(cat.showCats());
	}

	public void feedCats() {

		Scanner in = new Scanner(System.in);

		int id = 0;

		boolean isRight = false;
		while (!isRight) {
			try {
				System.out.println("Please enter the reference ID of the cat to feed: ");
				id = Integer.parseInt(in.next());
				isRight = true;
			} catch (Exception e) {
				System.out.println("Invalid Input!");
				continue;
			}
		}

		if (cat.feedCats(id)) {
			System.out.println(cat.getName() + ": Yum yum deliciouso.");
		} else {
			System.out.println("Cat has not been successfully feed or it was not found.");
		}
	}
}
