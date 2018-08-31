package com.exercise2;

public class Customer {
	
	private String fname;
	private String lname;
	private String gender;
	private boolean isMarried;
	public static int numFemales;
	public static int numMales;
	
	public Customer() {
		
	}
	
	public Customer(String fname, String lname, String gender, boolean isMarried) {
		this.fname = fname;
		this.lname = lname;
		this.isMarried = isMarried;
		
		if(gender.equals("M") || gender.equals("MALE")) {
			this.gender = "Male";
			numMales++;
		} else if(gender.equals("F") || gender.equals("FEMALE")) {
			this.gender = "Female";
			numFemales++;
		} else {
			this.gender = "";
		}
	}

	public String getFname() {
		return fname;
	}
	
	public String getLname() {
		return lname;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}

	public boolean isMarried() {
		return isMarried;
	}
	
	public String getFullName() {
		
		if(gender.equals("Male")) {
			return " Mr. " + fname + " " + lname;
		} else if(gender.equals("Female") && isMarried) {
			return " Mrs. " + fname + " " + lname;
		} else if(gender.equals("Female") && !isMarried) {
			return " Ms. " + fname + " " + lname;
		} else {
			return "Error";
		}
		
	}
	
	public static void displaySummary() {
		System.out.println("Number of females: " + numFemales);
		System.out.println("Number of males: " + numMales);
	}
}
