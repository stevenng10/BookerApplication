package com.exercise4_new;

public class Square extends Rectangle implements Resizable {
	
	public Square(){
		
	}
	
	public Square(double width, double height) {
		super(width,height);
	}

	public Square(double width, double height, String color, boolean filled) {
		super(width,height,color,filled);
	}
	
	public double getArea() {
		if(super.getWidth() >= super.getHeight()) {
			return super.getWidth() * super.getWidth();	
		} else {
			return super.getHeight() * super.getHeight();
		}
	}
	
	public double getPerimeter() {
		if(super.getWidth() >= super.getHeight()) {
			return 4 * super.getWidth();	
		} else {
			return 4 * super.getHeight();
		}	
	} 
	
	@Override
	public String showString() {
		if(super.getHeight() > 0 && super.getWidth() > 0) {
			return super.showString() + "\nArea: " + getArea() + 
					"\nPerimeter: " + getPerimeter();
		} else {
			return "Negative height or length";
		}
	}
	
	@Override
	public void resizeShapes(int percentage) {
		
		double real_percentage = (double)(percentage * 0.01);
		double new_area = getArea() * real_percentage;
		
		System.out.println("New area is: " + new_area);
		
		if(super.getWidth() >= super.getHeight()) {
			
			double new_width = getWidth() * Math.sqrt(real_percentage);
			System.out.println("New side is: " + new_width);
			
		} else {
			
			double new_height = getHeight() * Math.sqrt(real_percentage);
			System.out.println("New side is: " + new_height);
			
		}
	}
}
