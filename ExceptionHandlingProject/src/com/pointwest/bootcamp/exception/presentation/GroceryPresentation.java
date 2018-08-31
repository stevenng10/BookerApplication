package com.pointwest.bootcamp.exception.presentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.apache.log4j.Logger;

import com.pointwest.bootcamp.exception.exceptions.GroceryException;
import com.pointwest.bootcamp.exception.manager.GroceryManager;

public class GroceryPresentation {
	
	Logger logger = Logger.getLogger(GroceryPresentation.class);
	public void processGroceries() {
		GroceryManager gm = new GroceryManager();
		
		File outputFile = new File("receipt.txt");
		
		PrintWriter pw;
		
		try {
			pw = new PrintWriter(outputFile);
			pw.println("Your total bill is $" + gm.computeTotalGroceryBill());
			pw.close();
			System.out.println("done.");
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException occurred - input file not found: " +
					e.getMessage());
			System.out.println("File not found! Please try again later.");
		} catch (GroceryException e) {
			System.out.println("Uh oh!: " + e.getUserFriendlyErrorMessage());
		} catch (Exception e) {
			logger.error("Exception occured: " + e.getMessage());
			System.out.println("Error occurred. Please try again later!");
		}
		
	}
}
