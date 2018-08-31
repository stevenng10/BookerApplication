package com.people;

public class Teacher extends Person {
	
	private String subject;
	private double salary;
	
	public Teacher(String name, int age, int gender, String subject, double salary) {
		super(name,age,gender);
		this.subject = subject;
		if(salary > 0)
			this.salary = salary;
		else
			this.salary = 0;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		if(salary > 0)
			this.salary = salary;
		else
			this.salary = 0;
	}
	
	@Override
	public void showString() {
		if(age < 0 || salary < 0) {
			System.out.println("Error");
		} else {
			super.showString();
			System.out.println("Subject: " + subject);
			System.out.println("Salary: " + salary);
		}
	}
}
