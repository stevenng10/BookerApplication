package com.exercise3_new;

import java.util.Scanner;

public class Exercise2 {
	
	static Scanner in = new Scanner(System.in);
	static boolean isMarriedBool;
	static boolean isDone = false;
	static Customer cust;
	static Account acc;
	static Account[] accArray = new Account[10];
	static int counter = 0;
	static StudentAccount stud;
	static PayrollAccount payroll;
	static double balance;

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
			System.out.println("5) Search");
			System.out.println("6) Exit");
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
					case 2: printAcc();
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
					case 5: search();
						break;
					case 6: System.out.println("Thank you for using the system!");
						isDone = true;
						break;
					default: System.out.println("Invalid Input.");
						break;
				}
			}	
		}
	}
	
	public static void custCreate() {
		
		acc = null;
		
		System.out.println("Enter First Name: ");
		String fname = in.next();
		
		System.out.println("Enter Last Name: ");
		String lname = in.next();
		
		System.out.println("Enter Gender(M/F): ");
		String gender = in.next().toUpperCase();
		
		System.out.println("Are you married?(Y/N): ");
		String isMarried = in.next().toUpperCase();
		
		if(isMarried.equals("Y")) {
			isMarriedBool = true;
		} else {
			isMarriedBool = false;
		}
		
		cust = new Customer(fname, lname, gender, isMarriedBool);
		
		System.out.println("Type of Account: \n1)Student Account \n2)Payroll Account");
		int accountType = in.nextInt();
		
		while(accountType != 1 && accountType != 2) {
			System.out.println("Invalid Choice! Please enter valid input: ");
			System.out.println("Type of Account: \n1. Student Account \n2. Payroll Account");
			accountType = in.nextInt();
		}
			
		System.out.println("Outstanding Balance: ");
		double balance = in.nextDouble();
		
		while(balance < 0) {
			System.out.println("Cannot put an outstanding balance of negative!");
			System.out.println("Outstanding Balance: ");
		}
		
		if(accountType == 1) {
			if(balance >= StudentAccount.minBalance) {
				acc = new StudentAccount(cust, balance);
			} else {
				System.out.println("Outbalance is less than minimum "
						+ "balance for creation.(P" + StudentAccount.minBalance + ")");
			}
		} else {
			if(balance <= PayrollAccount.maxBalance) {
				acc = new PayrollAccount(cust, balance);
			} else {
				System.out.println("Outbalance is greater than maximum "
						+ "balance for creation.(P" + PayrollAccount.maxBalance + ")");
			}
			
		}
		
		if(acc != null) {
			accArray[counter] = acc;
			counter++;
			System.out.println(acc.showString());
			System.out.println("******************************");
		} else {
			System.out.println("Account not created!");
		}
			
	}
	
	public static void withdraw() {
		if(acc instanceof PayrollAccount) {
			System.out.println("Input the amount: ");
			double amount = in.nextDouble();
			
			((PayrollAccount)acc).withdrawCash(amount);
		} else {
			((StudentAccount) acc).withdrawCash();
		}
		
	}
	
	public static void deposit() {
		
		System.out.println("Input the amount: ");
		double amount = in.nextDouble();
		
		acc.depositCash(amount);
	}
	
	
	public static void printAcc() {
		double outBalFemale = 0;
		double outBalMale = 0;
		
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
		System.out.println("Total male outbalance:" + outBalMale);
		System.out.println("Total female outbalance:" + outBalFemale);
	}
	
	public static void search() {
		
		System.out.println("Search for people in the database:");
		int answer = in.nextInt();
		acc = accArray[answer - 1];
		acc.showString();
	}
}
