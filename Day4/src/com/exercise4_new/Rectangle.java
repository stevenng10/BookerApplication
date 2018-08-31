package com.exercise4_new;

public class Rectangle extends GeometricObject implements Resizable {

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

	@Override
	public void resizeShapes(int percentage) {
		
		double real_percentage = (double)(percentage * 0.01);
		double new_area = getArea() * real_percentage;
		double new_width = getWidth() * Math.sqrt(real_percentage);
		double new_height = getHeight() * Math.sqrt(real_percentage);
		
		System.out.println("New area is: " + new_area);
		System.out.println("New width is: " + new_width);
		System.out.println("New height is: " + new_height);
	}
}
