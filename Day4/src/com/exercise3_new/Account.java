package com.exercise3_new;

public class Account {
	
	private int accountNumber;
	private Customer accHolder;
	private double outBalance;
	private static int numAcc = 1;
	
	public Account(Customer accHolder, double outBalance) {
		this.accHolder = accHolder;
		this.outBalance = outBalance;
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
	
	public void setOutBalance(double outBalance) {
		this.outBalance = outBalance;
	}

	public static int getNumAcc() {
		return numAcc;
	}

	protected double withdrawCash(double amount) {
		
		if(amount < 0) {
			amount = 0;
			System.out.println("Cannot input negative amount.");
		}
		
		if(outBalance < amount) {
			amount = 0;
			System.out.println("Cannot input amount greater than outstanding balance.");
		}
		
		outBalance -= amount;
		
		return outBalance;
	}
	
	public double depositCash(double amount) {
		
		if(amount < 0) {
			amount = 0;
			System.out.println("Cannot input negative amount.");
		}
		
		outBalance += amount;
		
		return outBalance;
	}
	
	public String showString() {
		return accountNumber + accHolder.getFullName() + ": " + outBalance;
	}
}
