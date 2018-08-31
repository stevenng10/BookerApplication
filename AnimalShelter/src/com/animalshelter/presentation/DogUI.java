package com.animalshelter.presentation;

import java.util.Scanner;

import com.animalshelter.beans.InputBeans;
import com.animalshelter.manager.AnimalShelterManager;
import com.animalshelter.manager.DogManager;

public class DogUI {

	DogManager dog = new DogManager();
	AnimalShelterManager mng = new AnimalShelterManager();

	public void initializeDogMenu() {

		Scanner in = new Scanner(System.in);
		boolean isCorrect = false;

		while (!isCorrect) {

			System.out.println("Welcome to Dog Shelter!");
			System.out.println("Please select an option:");

			if (mng.countDogs() == 0) {
				System.out.println("[1] Add a Dog");
				System.out.println("[2] Go back to Home Page");
			} else if (mng.countDogs() > 0 && mng.countDogs() < 5) {
				System.out.println("[1] Add a dog");
				System.out.println("[2] Remove a Dog");
				System.out.println("[3] View all Dogs");
				System.out.println("[4] Feed Dogs");
				System.out.println("[5] Go back to Home Page");
			} else {
				System.out.println("[1] Remove a Dog");
				System.out.println("[2] View all Dogs");
				System.out.println("[3] Feed Dogs");
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
					continue;
				}
			}

			if (mng.countDogs() == 0) {
				switch (choice) {
				case 1:
					addDog();
					isCorrect = true;
					break;
				case 2:
					isCorrect = true;
					break;
				default:
					System.out.println("Invalid Input.");
					break;
				}
			} else if (mng.countDogs() > 0 && mng.countDogs() < 5) {
				switch (choice) {
				case 1:
					addDog();
					isCorrect = true;
					break;
				case 2:
					removeDog();
					isCorrect = false;
					continue;
				case 3:
					showDogs();
					isCorrect = false;
					continue;
				case 4:
					feedDogs();
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
					removeDog();
					isCorrect = false;
					continue;
				case 2:
					showDogs();
					isCorrect = false;
					continue;
				case 3:
					feedDogs();
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

	public void addDog() {

		Scanner in = new Scanner(System.in);
		InputBeans bean;
		boolean isCorrect = false;

		System.out.println("Please give the dog a name: ");
		String name = in.next();

		String gender = null;

		while (!isCorrect) {

			System.out.println("Please give the dog a gender(M/F): ");
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
				System.out.println("Please give the dog an age: ");
				age = Integer.parseInt(in.next());
				isRight = true;
			} catch (Exception e) {
				System.out.println("Invalid Input!");
				continue;
			}
		}

		bean = new InputBeans(name, age, gender);

		if (dog.addDog(bean)) {
			System.out.println("Dog is now added.");
		} else {
			System.out.println("Dog shelter full!");
		}
	}

	public void removeDog() {

		Scanner in = new Scanner(System.in);

		int id = 0;

		boolean isRight = false;
		while (!isRight) {
			try {
				System.out.println("Please enter the reference ID of the dog to remove: ");
				id = Integer.parseInt(in.next());
				isRight = true;
			} catch (Exception e) {
				System.out.println("Invalid Input!");
				continue;
			}
		}

		if (dog.removeDog(id)) {
			System.out.println("Dog has been successfully removed.");
		} else {
			System.out.println("Dog has not been successfully removed or it was not found.");
		}
	}

	public void showDogs() {
		System.out.println(dog.showDogs());
	}

	public void feedDogs() {

		Scanner in = new Scanner(System.in);

		int id = 0;

		boolean isRight = false;
		while (!isRight) {
			try {
				System.out.println("Please enter the reference ID of the dog to feed: ");
				id = Integer.parseInt(in.next());
				isRight = true;
			} catch (Exception e) {
				System.out.println("Invalid Input!");
				continue;
			}
		}

		if (dog.feedDogs(id)) {
			System.out.println(dog.getName() + ": Yum yum deliciouso.");
		} else {
			System.out.println("Dog has not been successfully feed or it was not found.");
		}
	}
}
