package com.exercise3;

public class Square extends Rectangle {
	
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
}
