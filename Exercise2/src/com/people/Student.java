package com.people;

public class Student extends Person {
	
	private int idNum;
	protected int GPA;
	
	public Student(String name, int age, int gender, int idNum, int GPA) {
		super(name, age, gender);
		this.idNum = idNum;
		if(GPA > 0)
			this.GPA = GPA;
		else 
			this.GPA = 0;
	}
	
	public int getIdNum() {
		return idNum;
	}
	public void setIdNum(int idNum) {
		this.idNum = idNum;
	}
	public int getGPA() {
		return GPA;
	}
	public void setGPA(int gPA) {
		if(GPA > 0)
			GPA = gPA;
		else 
			this.GPA = 0;
	}

	@Override
	public void showString() {
		if(age <= 0 || GPA <= 0) {
			System.out.println("Error");
		} else {
			super.showString();
			System.out.println("ID Number: " + idNum);
			System.out.println("GPA: " + GPA);
		}
	}
}
