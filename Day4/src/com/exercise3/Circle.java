package com.exercise3;

public class Circle extends GeometricObject {
	
	private double radius;
	
	public Circle(){
		
	}
	
	public Circle(double radius){
		super();
		setRadius(radius);
	}
	
	public Circle(double radius, String color, boolean filled){
		super(color, filled);
		if(radius > 0) {
			this.radius = radius;
		} else {
			System.out.println("Negative Radius");
		}
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		if(radius > 0) {
			this.radius = radius;
		} else {
			System.out.println("Negative Radius");
		}
	}
	
	public double getArea() {
		return radius * radius * Math.PI;
	}
	
	public double getPerimeter() {
		return getDiameter() * Math.PI;
	}
	
	public double getDiameter() {
		return 2 * radius;
	}
	
	public String getPrevString() {
		return super.showString();
	}
	
	@Override
	public String showString() {
		
		if(radius > 0) {
			return getPrevString() + "\nDiameter: " + getDiameter() + 
					"\nArea: " + getArea() + "\nPerimeter: " + getPerimeter();
		} else {
			return "";
		}
		
	}
}
