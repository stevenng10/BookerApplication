package com.people;

public class Testing {

	public static void main(String[] args) {
		
		Person colstud = new CollegeStudent("Steve", 18, 1, 2014072880, 1, "Communications", 2);
		Person teach = new Teacher("Zatura", 40, 2, "Chemistry", 25000);
		
		Student stud = (Student) colstud;
		
		stud.showString();
		System.out.println();
		
		colstud.showString();
		System.out.println();
		
		((Person)teach).showString();
		System.out.println();
		
		teach.showString();

	}

}
