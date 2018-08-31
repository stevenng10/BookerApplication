package com.animal;

public class TestAnimals {

	public static void main(String[] args) {
		
		Cat c = new Cat("Fluffers");
		Spider s = new Spider("Spinerella");
		Fish f = new Fish("Fishy");
		
		Animal fish = new Fish();
		Animal cat = new Cat();
		Animal spider = new Spider();
		
		c.play();
		c.eat();
		c.walk();
		
		System.out.println("");
		
		s.play();
		s.eat();
		s.walk();
		
		System.out.println("");
		
		f.play();
		f.eat();
		f.walk();
		
		System.out.println("");
		
		((Cat) cat).setName("Fuffy");
		((Cat) cat).play();
		((Cat) cat).eat();
		
		System.out.println("");
		
		((Fish) fish).setName("Fishter");
		((Fish) fish).play();
		((Fish) fish).eat();
		
		System.out.println("");
		
		((Spider) spider).setName("Spidey");
		((Spider) spider).play();
		((Spider) spider).eat();
		
		System.out.println("");
		
	}
}
