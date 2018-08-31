package com.exercise2;

public class Account {
	
	private int accountNumber;
	private Customer accHolder;
	private double outBalance;
	private static int numAcc = 1;
	
	public Account(Customer accHolder, double outBalance) {
		this.accHolder = accHolder;
		
		if(outBalance < 0 ) {
			outBalance = 0;
		} else {
			this.outBalance = outBalance;
		}
		accountNumber = numAcc;
		numAcc++;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public Customer getAccHolder() {
		return accHolder;
	}

	public double getOutBalance() {
		return outBalance;
	}
	
	public static int getNumAcc() {
		return numAcc;
	}

	public double withdrawCash(double amount) {
		outBalance -= amount;
		
		if(amount < 0) {
			amount = 0;
			System.out.println("Cannot input negative amount.");
		}
		
		if(outBalance < amount) {
			amount = 0;
			System.out.println("Cannot input amount greater than outstanding balance.");
		}
		
		return outBalance;
	}
	
	public double depositCash(double amount) {
		outBalance += amount;
		
		if(amount < 0) {
			amount = 0;
			System.out.println("Cannot input negative amount.");
		}
		
		return outBalance;
	}
	
	public String showString() {
		return accountNumber + accHolder.getFullName() + ": " + outBalance;
	}
}
