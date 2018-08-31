package com.account.manager;

import com.account.DAO.AccountDAO;
import com.account.beans.Account;
import com.account.beans.Customer;
import com.account.beans.InputBeanCustomer;
import com.account.beans.PayrollAccount;
import com.account.beans.StudentAccount;

public class CustomerCreationManager {
	
	public Account acc = null;
	int index;

	public boolean custCreate(InputBeanCustomer bean) {
		
		boolean isCreated = false;
		
		Customer cust = new Customer(bean.getFname(), bean.getLname(),
				bean.getGender(), bean.isMarried());
		
		if(bean.getAccountType() == 1) {
			if(bean.getBalance() >= StudentAccount.minBalance) {
				acc = new StudentAccount(cust, bean.getBalance());
			} else {
				System.out.println("Outbalance is less than minimum "
						+ "balance for creation.(P" + StudentAccount.minBalance + ")");
			}
		} else {
			if(bean.getBalance() <= PayrollAccount.maxBalance) {
				acc = new PayrollAccount(cust, bean.getBalance());
			} else {
				System.out.println("Outbalance is greater than maximum "
						+ "balance for creation.(P" + PayrollAccount.maxBalance + ")");
			}
			
		}
		
		if(acc != null) {
			AccountDAO.accounts.add(acc);
			index = AccountDAO.accounts.indexOf(acc);
			isCreated = true;
		}
		
		return isCreated;
	}
	
	public int getIndex() {
		return index;
	}
}
