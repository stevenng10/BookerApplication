package exercises;

public class Temperature {	
	
	public double temp;
	
	Temperature(double temp){
		this.temp = temp;
	}
	
	public double getCelsius() {
		
		double celsius = temp * 1.8 + 32;
		
		return celsius;
	}
	
	public double getFahrenheit() {
		
		double fahrenheit = (temp - 32) * 0.5556;
		
		return fahrenheit;
	}

}
