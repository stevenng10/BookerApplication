package com.account.presentation;

import java.util.Scanner;

import com.account.beans.Account;
import com.account.beans.InputBeanCustomer;
import com.account.manager.CustomerCreationManager;

public class CustomerCreationUI {
	
	Account acc;
	int index;
	
	public void initializaMenu() {
		
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

	public void custInitialize(Scanner in) {

		boolean isMarriedBool;
		
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
		
		if(gender.equals("M") || gender.equals("MALE")) {
			gender = "Male";
		} else if(gender.equals("F") || gender.equals("FEMALE")) {
			gender = "Female";
		} else {
			gender = "";
		}
		
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
		
		initislizeValue(fname,lname,gender,isMarriedBool,accountType,balance);
	}
	
	public void initislizeValue(String fname, String lname, String gender, 
			boolean isMarriedBool, int accountType, double balance) {
		
		InputBeanCustomer bean = new InputBeanCustomer(fname,lname,gender,isMarriedBool,
				accountType, balance);
		
		CustomerCreationManager mng = new CustomerCreationManager();
		if(mng.custCreate(bean)) {
			System.out.println("******************************");
			System.out.println(mng.acc.showString());
			System.out.println("******************************");
		} else {
			System.out.println("Account not created!");
		}
		
		index = mng.getIndex();
	}
	
	public int getIndex() {
		return index;
	}
}
