package com.animal;

public class Fish extends Animal implements Nameable{
	
	String name;
	
	public Fish() {
		this("");
	}

	protected Fish(String name) {
		super(0);
		this.name = name;
	}

	@Override
	void eat() {
		System.out.println("Fish eat other fish.");
	}
	
	@Override
	public void walk() {
		System.out.println("Fish can't walk and don't have legs.");
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String setName(String name) {
		return this.name = name;
	}

	@Override
	public void play() {
		System.out.println("Playing with " + name);
	}

}
