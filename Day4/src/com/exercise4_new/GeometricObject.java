package com.exercise4_new;

import java.util.Date;

public class GeometricObject {
	
	private String color;
	private boolean filled;
	private Date dateCreated = new Date(); 
	
	public GeometricObject(){
		if(color == null) {
			this.color = "white";
		}
	}
	
	public GeometricObject(String color, boolean filled){
		setColor(color);			
		setFilled(filled);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		if(color == null) {
			this.color = "white";
		} else {
			this.color = color;
		}
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		if(filled == true) {
			this.filled = filled;
		} else {
			this.filled = false;
		}	
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public String showString() {
		return "Color: " + color + "\nFilled: " + filled + 
				"\nDate Created: " + dateCreated;
	}
}
