package com.exercise4_new;

import java.util.Scanner;

public class Exercise3 {
	
	static Scanner in = new Scanner(System.in);
	static boolean isDone = false;
	static GeometricObject geom;
	static boolean isFilled = false;
	
	public static void main(String[] args) {
		chooseMenu();
	}
	
	public static void menu() {
		System.out.println("Please choose a shape to calculate: ");
		System.out.println("1) Circle");
		System.out.println("2) Cylinder");
		System.out.println("3) Rectangle");
		System.out.println("4) Square");
		System.out.println("5) Exit");
	}
	
	public static void chooseMenu() {
		
		while(!isDone) {
			
			menu();
			int choice = in.nextInt();
			
			switch(choice) {
				case 1: calcCircle();
					break;
				case 2: calcCylinder();
					break;
				case 3: calcRectangle();
					break;
				case 4: calcSquare();
					break;
				case 5: System.out.println("Thank you for using the system!");
					isDone = true;
					break;
				default: System.out.println("Invalid Input.");
					break;
			}
		}
	}
	
	public static void calcCircle() {
		
		System.out.println("Input radius: ");
		double radius = in.nextDouble();
		
		System.out.println("Is it filled?(Y/N)");
		String fill = in.next().toUpperCase();
		
		System.out.println("What color is it (default: white)? ");
		String color = in.next();
		
		if(fill.equals("Y") || fill.equals("YES")) {
			isFilled = true;
		} 
		
		geom = new Circle(radius,color,isFilled);
		System.out.println(geom.showString() + "\n");
		
		System.out.println("Do you want to resize your circle?(Y/N)");
		String answer = in.next().toUpperCase();
		
		switch(answer) {
			case "Y":
			case "YES": resizeCircle(geom);
				break;
			case "N":
			case "NO":
				break;
			default: System.out.println("Invalid Input.");
				break;
		}
	}
	
	public static void calcCylinder() {
		
		System.out.println("Input radius: ");
		double radius = in.nextDouble();
		
		System.out.println("Input height: ");
		double height = in.nextDouble();
		
		System.out.println("Is it filled?(Y/N)");
		String fill = in.next().toUpperCase();
		
		System.out.println("What color is it (default: white)? ");
		String color = in.next();
		
		if(fill.equals("Y") || fill.equals("YES")) {
			isFilled = true;
		} 
		
		geom = new Cylinder(height,radius,color,isFilled);
		System.out.println(geom.showString() + "\n");
		
		System.out.println("Do you want to fill your cylinder?(Y/N)");
		String answer = in.next().toUpperCase();
		
		switch(answer) {
			case "Y":
			case "YES": fillCylinder(geom);
				break;
			case "N":
			case "NO":
				break;
			default: System.out.println("Invalid Input.");
				break;
		}
	}
	
	public static void calcRectangle() {
		
		System.out.println("Input width: ");
		double width = in.nextDouble();
		
		System.out.println("Input height: ");
		double height = in.nextDouble();
		
		System.out.println("Is it filled?(Y/N)");
		String fill = in.next().toUpperCase();
		
		System.out.println("What color is it (default: white)? ");
		String color = in.next();
		
		if(fill.equals("Y") || fill.equals("YES")) {
			isFilled = true;
		} 
		
		geom = new Rectangle(width,height,color,isFilled);
		System.out.println(geom.showString() + "\n");
		
		System.out.println("Do you want to resize your rectangle?(Y?N)");
		String answer = in.next().toUpperCase();
		
		switch(answer) {
			case "Y":
			case "YES": resizeRectangle(geom);
				break;
			case "N":
			case "NO":
				break;
			default: System.out.println("Invalid Input.");
				break;
		}
	}
	
	public static void calcSquare() {
		
		System.out.println("Input width: ");
		double width = in.nextDouble();
		
		System.out.println("Input height: ");
		double height = in.nextDouble();
		
		System.out.println("Is it filled?(Y/N)");
		String fill = in.next().toUpperCase();
		
		System.out.println("What color is it (default: white)? ");
		String color = in.next();
		
		if(fill.equals("Y") || fill.equals("YES")) {
			isFilled = true;
		} 
		
		geom = new Square(width,height,color,isFilled);
		System.out.println(geom.showString() + "\n");
		
		System.out.println("Do you want to resize your square?(Y/N)");
		String answer = in.next().toUpperCase();
		
		switch(answer) {
			case "Y":
			case "YES": resizeSquare(geom);
				break;
			case "N":
			case "NO":
				break;
			default: System.out.println("Invalid Input.");
				break;
		}
	}
	
	public static void resizeCircle(GeometricObject geom) {
		
		Circle circ = (Circle) geom;
		
		System.out.println("Input resize value: (100 as base)");
		int percentage = in.nextInt();
		
		circ.resizeShapes(percentage);
	}
	
	public static void resizeRectangle(GeometricObject geom) {
		
		Rectangle rec = (Rectangle) geom;
		
		System.out.println("Input resize value: (100 as base)");
		int percentage = in.nextInt();
		
		rec.resizeShapes(percentage);
	}
	
	public static void resizeSquare(GeometricObject geom) {
		
		Square sqa = (Square) geom;
		
		System.out.println("Input resize value: (100 as base)");
		int percentage = in.nextInt();
		
		sqa.resizeShapes(percentage);
	}
	
	public static void fillCylinder(GeometricObject geom) {
		
		Cylinder cyl = (Cylinder) geom;
		
		System.out.println("Input fill value: (0 as base)");
		int percentage = in.nextInt();
		
		cyl.fillShapes(percentage);
	}
}
