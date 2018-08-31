package com.exercise3;

public class Exercise3 {
	
	public static void main(String[] args) {
		GeometricObject circ = new Circle(3.5, "red", true);
		GeometricObject circ2 = new Circle(3.5);
		Circle cyl = new Cylinder(5, 3.5, "red", true);
		Rectangle rec = new Rectangle(15, 10, "green", false);
		Square sqa = new Square(15, 10, "green", false);
		
		System.out.println(circ.showString() + "\n");
		System.out.println(circ2.showString() + "\n");
		System.out.println(cyl.showString()+ "\n");
		System.out.println(rec.showString()+ "\n");
		System.out.println(sqa.showString()+ "\n");
	}
}
