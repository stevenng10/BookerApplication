package com.account.presentation;

import java.util.Scanner;

import com.account.manager.SearchManager;

public class SearchUI {
	
	int index = 0;
	
	public void searchPerson(Scanner in) {
		
		SearchManager search = new SearchManager();
		
		System.out.println("Search for people in the database:");
		int answer = in.nextInt();
		
		if(search.searchFunc(answer)) {
			System.out.println("********************");
			System.out.println(search.acc.showString());
			System.out.println("********************");
		} else {
			System.out.println("Cannot find user!");
		}
		
		index = search.getIndex();
	}
	
	public int getIndex() {
		return index;
	}

}
