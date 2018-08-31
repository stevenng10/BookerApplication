package com.account.presentation;

import java.util.Scanner;

import com.account.manager.DepositManager;

public class DepositUI {

	public void depositMoney(Scanner in, int index) {
		
		DepositManager deposit = new DepositManager();
		
		System.out.println("Input the amount: ");
		double amount = in.nextDouble();
		
		deposit.getAccount(index);
		deposit.depositMoneyStudent(amount);

	}
}
