package com.account.manager;

import com.account.DAO.AccountDAO;
import com.account.beans.Account;

public class SearchManager {
	
	public Account acc;
	int accNum = 0;

	public boolean searchFunc(int answer) {
		
		boolean exist = false;
		
		for(int i = 0; i < AccountDAO.accounts.size(); i++){
	        if(AccountDAO.accounts.get(i).getAccountNumber() == answer){
	            exist = true;
	            accNum = i;
	            break;
	        }
		}
		
		if(exist) {
			acc = AccountDAO.accounts.get(accNum);
		} 
		
		return exist;
	}
	
	public int getIndex() {
		return accNum;
	}
}
