package com.exercise4_new;

public class Cylinder extends Circle implements Fillable {
	
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
			+ "\nVolume: " + getVolume();
		} else {
			return "";
		}
	}

	@Override
	public void fillShapes(int percentage) {
		
		double real_percentage = (percentage * 0.01);
		if(real_percentage > 100) {
			System.out.println("cannot exceed 100 since it will overflow.");
		} else {
			double new_vol = getVolume() * (1 - real_percentage);
			System.out.println("Remaining volume is: " + new_vol);
		}
	}
}
