package com.animal;

public class Cat extends Animal implements Nameable {
	
	String name;

	protected Cat() {
		this("");
	}
	
	protected Cat(String name) {
		super(4);
		this.name = name;
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

	@Override
	public void eat() {
		System.out.println("Cats eat mice and fish.");
	}

}
