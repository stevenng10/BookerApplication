package com.people;

public class Person {

	private String name;
	protected int age;
	private int gender;
	
	public Person(String name, int age, int gender) {
		this.name = name;
		this.gender = gender;
		if(age > 0)
			this.age = age;
		else 
			this.age = 0;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age > 0)
			this.age = age;
		else 
			this.age = 0;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	
	public void showString() {
		
		if(age <= 0 ) {
			System.out.println("Error");
		} else {
			String genderString = "";
			System.out.println("Name: " + name);
			System.out.println("Age: " + age);
			if(gender == 1) {
				genderString = "Male";
				System.out.println("Gender: " + genderString);
			} else {
				genderString = "Female";
				System.out.println("Gender: " + genderString);
			}
		}
	}
}
