package com.account.manager;

import com.account.beans.Account;

import java.util.ArrayList;
import java.util.List;

import com.account.DAO.*;

public class DisplayManager {

	public List<String> getDisplay() {
		
		double outBalFemale = 0;
		double outBalMale = 0;
		List<String> list = new ArrayList<String>();
		
		for(Account account: AccountDAO.accounts ) {
			if(account != null) {
				
				list.add(account.showString());
				
				if(account.getAccHolder().getGender().equals("Male")) {
					outBalMale += account.getOutBalance();
				} else {
					outBalFemale += account.getOutBalance();
				}
			}
		}
		list.add(String.valueOf(outBalFemale));
		list.add(String.valueOf(outBalMale));
		
		return list;
	}
}
