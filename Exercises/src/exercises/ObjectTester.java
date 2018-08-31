package exercises;

public class ObjectTester {

	public static void main(String[] args) {
		
		//Exercise Circle
		Circle circle = new Circle(5);
		System.out.println("The area is: " + circle.getArea());
		System.out.println("The area is: " + circle.getCircumference());
		
		//Temperature
		Temperature temp1 = new Temperature(30);
		Temperature temp2 = new Temperature(100);
		System.out.println("The Fahrenheit is: " + temp2.getFahrenheit());
		System.out.println("The Celsius is: " + temp1.getCelsius());
		
		//Time
		Time time1 = new Time(1,20);
		time1.displayTime();
		time1.displayMinute();
		
		Time time2 = new Time(2,50);
		time2.displayTime();
		time2.displayMinute();
		
		time1.addTime(time1, time2);
		
		//Holiday
		Holiday[] holidayArray = new Holiday[3];
		Holiday h1 = new Holiday("Independence Day", 4, "July");
		holidayArray[0] = h1;
		Holiday h2 = new Holiday("Independence Day", 4, "July");
		holidayArray[1] = h2;
		Holiday h3 = new Holiday("Christmas Day", 25, "December");
		holidayArray[2] = h3;
		
		System.out.println(h1.inSameMonth(h1, h2));
		System.out.println(h1.inSameMonth(h1, h3));
		System.out.println(Holiday.avgDate(holidayArray));
		
		//Movie
		Movie[] movie = new Movie[2];
		Movie m1 = new Movie("Casion Royale", "Eon Productions", "PG-13");
		movie[0] = m1;
		Movie m2 = new Movie("Rush Hour", "Eon Productions", "PG");
		movie[1] = m2;
		
		Movie.getPG(movie);
	}

}
