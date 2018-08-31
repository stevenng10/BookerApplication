package com.animal;

public class Spider extends Animal implements Nameable{
	
	String name;
	
	public Spider() {
		this("");
	}
	
	public Spider(String name){
		super(8);
		this.name = name;
	}

	@Override
	public void eat() {
		System.out.println("Spiders eat insects.");
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
