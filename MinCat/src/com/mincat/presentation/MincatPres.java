package com.mincat.presentation;

import java.util.Scanner;

import com.mincat.manager.MincatManager;

public class MincatPres {

	public void execute() {
		
		Scanner in = new Scanner(System.in);
		MincatManager mng = new MincatManager();
		
		System.out.println("Enter a string for value A:");
		String inputA = in.next();
		
		System.out.println("Enter a string for value B:");
		String inputB = in.next();
		
		mng.minCat(inputA, inputB);
	}
}
