package com.account.manager;

import com.account.beans.PayrollAccount;
import com.account.beans.StudentAccount;
import com.account.DAO.AccountDAO;
import com.account.beans.Account;

public class WithdrawManager {
	
	Account acc;
	
	public Account getAccount(int index) {
		acc = AccountDAO.accounts.get(index);
		return acc;
	}
	
	public void withdrawMoneyPayroll(double amount) {
		((PayrollAccount)acc).withdrawCash(amount);
	}
	
	public void withdrawMoneyStudent() {
		((StudentAccount) acc).withdrawCash();

	}
}
