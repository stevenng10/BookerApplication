package com.account.manager;

import com.account.DAO.AccountDAO;
import com.account.beans.Account;

public class DepositManager {
	
	Account acc;
	
	public Account getAccount(int index) {
		acc = AccountDAO.accounts.get(index);
		return acc;
	}

	public void depositMoneyStudent(double amount) {
		acc.depositCash(amount);
	}
}
