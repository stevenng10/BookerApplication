package com.exercise3;

public class Rectangle extends GeometricObject {

	private double width;
	private double height;
	
	public Rectangle(){
		
	}
	
	public Rectangle(double width, double height){
		super();
		setWidth(width);
		setHeight(height);
	}
	
	public Rectangle(double width, double height, String color, boolean filled){
		super(color,filled);
		setWidth(width);
		setHeight(height);
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		if(width > 0) {
			this.width = width;
		} else {
			System.out.println("Negative Width");
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
	
	public double getArea() {
		return width * height;	
	}
	
	public double getPerimeter() {
		return 2 * (width + height);	
	}
	
	public String getPrevString() {
		return super.showString();
	}
	
	@Override
	public String showString() {
		if(width > 0 && height > 0) {
			return getPrevString() + "\nArea: " + getArea() + 
					"\nPerimeter: " + getPerimeter();
		} else {
			return "";
		}
		
	}
}
