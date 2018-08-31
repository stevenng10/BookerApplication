package com.account.presentation;

import java.util.List;

import com.account.manager.DisplayManager;

public class DisplayUI {
	
	public void printAcc() {
		
		DisplayManager disp = new DisplayManager();
		
		List<String> list = disp.getDisplay();
		
		for(int i = 0; i < list.size() - 2; i++) {
			System.out.println("******************************");
			System.out.println(list.get(i));
			System.out.println("******************************");
		}
		System.out.println("Total Female Balance: " + list.get(list.size()-1));
		System.out.println("Total Male Balance: " + list.get(list.size()-2));
	}
}
