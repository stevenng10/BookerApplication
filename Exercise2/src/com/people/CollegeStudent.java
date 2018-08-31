package com.people;

public class CollegeStudent extends Student {
	
	private String major;
	private int year;
	
	public CollegeStudent(String name, int age, int gender, int idNum, int GPA,
			String major, int year) {
		super(name,age,gender,idNum,GPA);
		this.major = major;
		if(year < 0 && year > 5)
			this.year = year;
		else
			this.year = 0;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if(year < 0 && year > 5)
			this.year = year;
		else
			this.year = 0;
	}

	@Override
	public void showString() {
		
		if(age <= 0 || GPA <= 0 || year <= 0 && year > 5) 
			System.out.println("Error");
		else {
			String yearStr = "";
			super.showString();
			System.out.println("Major: " + major);
			
			if(year == 1) {
				yearStr = "Freshman";
				System.out.println(yearStr + " Year");
			} else if (year == 2) {
				yearStr = "Sophomore";
				System.out.println(yearStr + " Year");
			} else if (year == 3) {
				yearStr = "Junior";
				System.out.println(yearStr + " Year");
			} else {
				yearStr = "Senior";
				System.out.println(yearStr + " Year");
			}
		}
	}
}
