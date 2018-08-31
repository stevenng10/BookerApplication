package com.pointwest.bootcamp.exception.beans;

public class GroceryItem {
	private String name;
	private int quantity;
	private double unitPrice;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public double computeTotalLinePrice() {
		return unitPrice * quantity;
	}
	
}
