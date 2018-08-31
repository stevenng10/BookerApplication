package com.pointwest.bootcamp.exception.repository;

import java.util.List;

import org.junit.Test;
import com.pointwest.bootcamp.exception.beans.GroceryItem;
import com.pointwest.bootcamp.exception.exceptions.GroceryException;

import org.junit.Assert;
import org.junit.Before;

public class GroceryRepositoryTest {
	
	GroceryRepository gr;
	
	@Before
	public void setup() {
		gr = new GroceryRepository();
		System.out.println("@Before");
	}

	@Test
	public void checkIfListIsPopulatedCorrectly() {
		// Given/Arrange
		//GroceryRepository gr = new GroceryRepository();
		List<GroceryItem> groceries = null;
		
		// When/Act
		try {
			groceries = gr.getGroceryList();
			
		} catch(GroceryException e) {
			e.printStackTrace();
		}
		
		// Then/Assert
		Assert.assertEquals("apple", groceries.get(0).getName());
		Assert.assertEquals(2, groceries.get(0).getQuantity());
		Assert.assertEquals(2.99, groceries.get(0).getUnitPrice(), 0.01);
	}
	
	@Test
	public void checkIfListIsNotNull() {
		try {
			List<GroceryItem> groceries = gr.getGroceryList();
			
			Assert.assertNotNull(groceries);
		} catch(GroceryException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void checkIfListHasSizeEqualsThree() {
		try {
			List<GroceryItem> groceries = gr.getGroceryList();
			
			Assert.assertEquals(3, groceries.size());
		} catch(GroceryException e) {
			e.printStackTrace();
		}
	}
	
	@Test(expected = GroceryException.class)
	public void checkIfThrowsGroceryException() throws GroceryException{
		gr.setFileName("grocery.txt");
		gr.getGroceryList();
	}
}
