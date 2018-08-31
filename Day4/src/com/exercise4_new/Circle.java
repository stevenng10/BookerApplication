package com.exercise4_new;

public class Circle extends GeometricObject implements Resizable {
	
	private double radius;
	
	public Circle(){
		
	}
	
	public Circle(double radius){
		super();
		setRadius(radius);
	}
	
	public Circle(double radius, String color, boolean filled){
		super(color, filled);
		setRadius(radius);
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

	@Override
	public void resizeShapes(int percentage) {
		
		double new_area = getArea() * (double)(percentage * 0.01);
		double new_radius = Math.sqrt(new_area/Math.PI);
		
		System.out.println("New area is: " + new_area);
		System.out.println("New radius is: " + new_radius);
	}
}
