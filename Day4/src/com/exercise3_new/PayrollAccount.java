package com.exercise3_new;

public class PayrollAccount extends Account {

	public static final int maxBalance = 20000;
	private double outBal = getOutBalance();
	
	public PayrollAccount(Customer accHolder, double outBalance) {
		super(accHolder, outBalance);
	}
	
	@Override
	public double withdrawCash(double amount) {
		
		if(amount < 0) {
			amount = 0;
			System.out.println("Cannot input negative amount.");
		}
		
		if(outBal < (amount + 50)) {
			amount = 0;
			System.out.println("Cannot input amount greater than outstanding balance.");
			outBal -= amount;
		} else {
			outBal -= (amount + 50);
		}
		
		super.setOutBalance(outBal);
		return outBal;
	}
	
	@Override
	public double depositCash(double amount) {
		
		if(amount < 0) {
			amount = 0;
			System.out.println("Cannot input negative amount.");
		}
		
		if(maxBalance < (outBal + amount)) {
			amount = 0;
			System.out.println("Exceed Balance.");
		}
		
		outBal += amount;
		
		super.setOutBalance(outBal);
		return outBal;
	}
}
