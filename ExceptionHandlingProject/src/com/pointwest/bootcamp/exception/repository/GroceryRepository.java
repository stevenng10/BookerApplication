package com.pointwest.bootcamp.exception.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.pointwest.bootcamp.exception.beans.GroceryItem;
import com.pointwest.bootcamp.exception.exceptions.GroceryException;

public class GroceryRepository {
	
	Logger logger = Logger.getLogger(GroceryRepository.class);
	String fileName = "groceries.txt";
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<GroceryItem> getGroceryList() throws GroceryException{
		File inputFile = new File(fileName);
		List<GroceryItem> groceries = new ArrayList<GroceryItem>();
		try {
			Scanner inputScanner = new Scanner(inputFile);
			String[] details;
			GroceryItem item;
			while(inputScanner.hasNext()) {
				details = inputScanner.nextLine().split("\\|");
				item = new GroceryItem();
				
				item.setName(details[0]);
				item.setQuantity(Integer.parseInt(details[1]));
				item.setUnitPrice(Double.parseDouble(details[2]));
				
				groceries.add(item);
			}
			inputScanner.close();
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException occurred - input file not found: " +
			e.getMessage());
			throw new GroceryException(e,"File not found.");
		} catch(Exception e) {
			logger.error("Exception occured: " + e.getMessage());
			throw new GroceryException(e,"Error occurred. Please try again later...");
		} finally {
			logger.info("Finally it happens!");
		}
		System.out.println("done repository.");
		return groceries;
	}
}
