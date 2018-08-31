package hello;

import java.util.Scanner;

public class Exercise {

	public static void main(String[] args) {
		
		//Exercise 1
		/*Scanner input = new Scanner(System.in);
		System.out.print("Input 1st number:");
		int num1 = input.nextInt();
		System.out.print("Input 2nd number:");
		int num2 = input.nextInt();
		
		int sum = num1 + num2;
		int diff = num1 - num2;
		int prod = num1 * num2;
		int div = num1 / num2;
		int mod = num1 % num2;
		
		System.out.println("The sum of two numbers are: " + sum);
		System.out.println("The difference of two numbers are: " + diff);
		System.out.println("The product of two numbers are: " + prod);
		System.out.println("The quotient of two numbers are: " + div);
		System.out.println("The remainder of two numbers are: " + mod);
		input.close();*/
		
		//Exercise 2
		/*Scanner input = new Scanner(System.in);
		System.out.print("Input Fahrenheit:");
		float fahren = input.nextFloat();

		float celcius = (float) ((fahren - 32) * 0.5556);
		System.out.println("Fahrenheit converted to Celcius : " + celcius + " C");
		input.close();*/
		
		//Exercise 3
		/*Scanner input = new Scanner(System.in);
		System.out.print("Input Height(in cm): ");
		float heightCM = input.nextFloat();
		System.out.print("Input Weight(in kg): ");
		float weight = input.nextFloat();
		
		float heightM = (float) Math.pow((heightCM / 100), 2);
		float bmi = weight / heightM;

		if(bmi < 18.5) {
			System.out.println("You are underweight with " + bmi + ".");
		} else if (bmi >= 18.5 && bmi <= 24.9 ) {
			System.out.println("You are normal with " + bmi + ".");
		} else if (bmi >= 25 && bmi < 30) {
			System.out.println("You are overweight with " + bmi + ".");
		} else {
			System.out.println("You are obese with " + bmi + ".");
		}
		input.close();*/
		
		//Exercise 4
		/*Scanner input = new Scanner(System.in);
		System.out.print("Input Number: ");
		float num = input.nextFloat();
		
		float sqr = (float) Math.pow(num, 2);
		float cube = (float) Math.pow(num, 3);
		float fourth = (float) Math.pow(num, 4);
		
		System.out.println(num + " squared is : " + sqr);
		System.out.println(num + " cubed is : " + cube);
		System.out.println(num + " int the fourth power is : " + fourth);
		input.close();*/
		
		//Exercise 5
		/*Scanner input = new Scanner(System.in);
		System.out.print("Input Seconds: ");
		int num = input.nextInt();
		int hour = num / 3600;
		int hour2 = num % 3600;
		int min = hour2 / 60;
		int min2 = hour2 % 60;
		
		System.out.println("The seconds converted in hh:mm:ss format: " +
		hour + "h:" + min + "min:" + min2 + "s");
		input.close();*/
		
		//Exercise 6 or Bonus
		/*Scanner input = new Scanner(System.in);
		System.out.print("Input 1st number: ");
		float num1 = input.nextFloat();
		System.out.print("Input 2nd number: ");
		float num2 = input.nextFloat();
		System.out.print("Input 3rd number: ");
		float num3 = input.nextFloat();
		
		float mean = (num1 + num2 + num3) / 3;
		float var = (float) (Math.pow(num1 - mean, 2) + Math.pow(num2 - mean, 2) +
				Math.pow(num3 - mean, 2)) ;
		float var2 = var / 3;
		float stdev = (float) Math.sqrt(var2);
		
		System.out.println("The mean of 3 numbers: " + mean);
		System.out.println("The variance of 3 numbers: " + var2);
		System.out.println("The standard deviation of 3 numbers: " + stdev);
		input.close();*/
	}

}
