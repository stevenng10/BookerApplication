package com.account.presentation;

import java.util.Scanner;

import com.account.beans.PayrollAccount;
import com.account.manager.WithdrawManager;

public class WithdrawUI {
	
	public void withdrawMoney(Scanner in, int index) {
		
		WithdrawManager withdraw = new WithdrawManager();

		if(withdraw.getAccount(index) instanceof PayrollAccount) {
			
			System.out.println("Input the amount: ");
			double amount = in.nextDouble();
			
			withdraw.withdrawMoneyPayroll(amount);
		} else {
			withdraw.withdrawMoneyStudent();
		}
	}
}
