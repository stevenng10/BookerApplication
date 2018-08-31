package com.exercise2;

import java.util.Scanner;

public class Exercise2 {
	
	static Scanner in = new Scanner(System.in);
	static boolean isMarriedBool;
	static boolean isDone = false;
	static Customer cust;
	static Account acc;
	static Account[] accArray = new Account[10];
	static int counter = 0;

	public static void main(String[] args) {
		chooseMenu();
	}

	public static void Menu() {		
		if(Account.getNumAcc() == 1) {
			System.out.println("1) Create new aocount");
			System.out.println("2) Display Summary");
			System.out.println("3) Exit");
		} else {
			System.out.println("1) Create new account");
			System.out.println("2) Withdraw");
			System.out.println("3) Deposit");
			System.out.println("4) Display Summary");
			System.out.println("5) Exit");
		}
	}
	
	public static void chooseMenu() {
		
		while(!isDone) {
			
			Menu();
			int choice = in.nextInt();
			
			if(Account.getNumAcc() == 1) {
				
				switch(choice) {
					case 1: custCreate();
						break;
					case 2: System.out.println(acc.showString());;
						break;
					case 3: System.out.println("Thank you for using the system!");
						isDone = true;
						break;
					default: System.out.println("Invalid Input.");
						break;
				}
					
			} else {
				
				switch(choice) {
				
					case 1: custCreate();
						break;
					case 2: withdraw();
						break;
					case 3: deposit();
						break;
					case 4: printAcc();
						break;
					case 5: System.out.println("Thank you for using the system!");
						isDone = true;
						break;
					default: System.out.println("Invalid Input.");
						break;
				
				}
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
		
		System.out.println("Are you married?(Y/N): ");
		String isMarried = in.next().toUpperCase();
		
		System.out.println("Outstanding Balance: ");
		double balance = in.nextDouble();
		
		while(balance < 0) {
			System.out.println("Cannot put an outstanding balance of negative!");
			System.out.println("Outstanding Balance: ");
			balance = in.nextDouble();
		}
		
		if(isMarried.equals("Y")) {
			isMarriedBool = true;
		} else {
			isMarriedBool = false;
		}
		
		cust = new Customer(fname, lname, gender, isMarriedBool);
		acc = new Account(cust, balance);
		accArray[counter] = acc;
		counter++;
		System.out.println(acc.showString());
		System.out.println("******************************");
		
		return cust;
	}
	
	public static void withdraw() {
		
		System.out.println("Input the amount: ");
		double amount = in.nextDouble();
		
		acc.withdrawCash(amount);
	}
	
	public static void deposit() {
		
		System.out.println("Input the amount: ");
		double amount = in.nextDouble();
		
		acc.depositCash(amount);
	}
	
	public static void printAcc() {
		
		int outBalFemale = 0;
		int outBalMale = 0;
		
		for(Account account: accArray ) {
			if(account != null) {
				
				System.out.println(account.showString());
				
				if(account.getAccHolder().getGender().equals("Male")) {
					outBalMale += account.getOutBalance();
				} else {
					outBalFemale += account.getOutBalance();
				}
			}
		}
		System.out.println("Total Male outbalance: " + outBalMale);
		System.out.println("Total Female outbalance: " + outBalFemale);
	}
}
