package com.exercise3;

public class Cylinder extends Circle {
	
	private double height;
	
	public Cylinder(){
		
	}

	public Cylinder(double height, double radius){
		super(radius);
		setHeight(height);
	}
	
	public Cylinder(double height, double radius, String color, boolean filled){
		super(radius, color, filled);
		if(height > 0) {
			this.height = height;
		} else {
			System.out.println("Negative Height");
		}
	}
	
	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		if(height > 0) {
			this.height = height;
		} else {
			System.out.println("Negative Height");
		}
	}
	
	public double getVolume() {
		return getArea() * height;
	}

	public double getSurfaceArea() {
		return getPerimeter() * height + 2 * getArea();
	}
	
	@Override
	public String showString() {
		if(height > 0) {
			return super.getPrevString() + "\nSurface Area: " + getSurfaceArea()
			+ "\nPerimeter: " + getVolume();
		} else {
			return "";
		}
	}
}
