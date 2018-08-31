package com.exercise3_v2;

public class StudentAccount extends Account {
	
	public static final double minBalance = 1000;
	private static final double withdrawAmt = 500;
	private double outBal = super.getOutBalance();
	private double withdrawal = withdrawAmt;

	public StudentAccount(Customer accHolder, double outBalance) {
		super(accHolder, outBalance);
	}
	
	public double withdrawCash() {
		
		if(minBalance > (outBal - withdrawal)) {
			withdrawal = 0;
			System.out.println("Cannot withdraw cash below minumum balance.");
		}
		System.out.println("Withdrawed: P" + withdrawal);
		outBal -= withdrawal;
		
		super.setOutBalance(outBal);
		return outBal;
	}
}
