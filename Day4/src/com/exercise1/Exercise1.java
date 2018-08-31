package com.exercise1;

import java.util.Scanner;

public class Exercise1 {
	
	static Scanner in = new Scanner(System.in);
	static boolean isMarriedBool;
	static boolean isDone = false;
	static Customer cust;

	public static void main(String[] args) {
		
		chooseMenu();
		
	}

	public static void Menu() {
		
		System.out.println("1) Create new customer");
		System.out.println("2) Display Summary");
		System.out.println("3) Exit");
		
	}
	
	public static void chooseMenu() {
		
		while(!isDone) {
			
			Menu();
			int choice = in.nextInt();
			
			switch(choice) {
				case 1: custCreate();
					break;
				case 2: Customer.displaySummary();
					break;
				case 3: System.out.println("Thank you for using the system!");
					isDone = true;
					break;
				default: System.out.println("Invalid Input.");
					break;
			}
			
		}
		
	}
	
	public static Customer custCreate() {
		
		System.out.println("Enter First Name: ");
		String fname = in.next();
		
		System.out.println("Enter Last Name: ");
		String lname = in.next();
		
		System.out.println("Enter Gender(M/F): ");
		String gender = in.next().toUpperCase();
		
		System.out.println("Are you married?(Y/N) : ");
		String isMarried = in.next().toUpperCase();
		
		if(isMarried.equals("Y")) {
			isMarriedBool = true;
		} else {
			isMarriedBool = false;
		}
		
		Customer cust = new Customer(fname, lname, gender, isMarriedBool);
		System.out.println("Hello " + cust.getFullName());
		
		return cust;
	}
}
