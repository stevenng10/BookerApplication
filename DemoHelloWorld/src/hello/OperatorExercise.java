package hello;

import java.util.Scanner;

public class OperatorExercise {

	public static void main(String[] args) {

		//Exercise 1
		/*Scanner input = new Scanner(System.in);
		System.out.print("Input 1st number:");
		int num1 = input.nextInt();
		int num1b = num1 < 0 || num1 > 21 ? 0 : num1;
		System.out.print("Input 2nd number:");
		int num2 = input.nextInt();
		int num2b = num2 < 0 || num2 > 21 ? 0 : num2;
		
		if(num1b >= num2b) {	
			System.out.println(num1b);
		}else {
			System.out.println(num2b);
		}
		input.close();*/

		//Exercise 2
		/*Scanner input = new Scanner(System.in);
		System.out.print("Input Year:");
		int year = input.nextInt();
		
		if(year % 4 == 0 && year % 400 == 0 || year % 100 != 0)
			System.out.println(year + " is a leap year.");
		else
			System.out.println(year + " is NOT a leap year.");
		input.close();*/
		
		//Exercise 3
		/*Scanner input = new Scanner(System.in);
		System.out.print("Input Number:");
		int num1 = input.nextInt();
		int counter = 0;
		
		if(num1 > 1) {
			for(int i = 2; i <= num1/2; i++) {
				if(num1 % i == 0) {
					System.out.println("false");
					++counter;
					break;
				}
			}
			if(counter == 0) {
				System.out.println("true");
			}
		} else {
			System.out.println("false");
		}
		input.close();*/
		
	}

}
