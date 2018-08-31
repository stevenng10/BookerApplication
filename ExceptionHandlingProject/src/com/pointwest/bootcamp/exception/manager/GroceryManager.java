package com.pointwest.bootcamp.exception.manager;

import com.pointwest.bootcamp.exception.beans.GroceryItem;
import com.pointwest.bootcamp.exception.exceptions.GroceryException;
import com.pointwest.bootcamp.exception.repository.GroceryRepository;

public class GroceryManager {
	public double computeTotalGroceryBill() throws GroceryException {
		double total = 0;
		
		GroceryRepository gr = new GroceryRepository();
		
		for(GroceryItem item:gr.getGroceryList()) {
			total += item.computeTotalLinePrice();
		}
		
		return total;
	}
}
