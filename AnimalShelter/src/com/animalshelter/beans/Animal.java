package com.animalshelter.beans;

public abstract class Animal {
	
	private String name, gender;
	private int age, id;
	static int numAnimal = 1;
	
	public Animal(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.id = numAnimal++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}
}
