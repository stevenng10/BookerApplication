package exercises;

public class Circle {
		
	public double radius = 0;
	
	Circle(double radius){
		this.radius = radius;
	}
	
	public double getArea() {
		
		double area = radius * radius * 3.14159;
		
		return area;
	}
	
	public double getCircumference() {
		
		double circumference = 2 * radius * 3.14159;
		
		return circumference;
	}
}
