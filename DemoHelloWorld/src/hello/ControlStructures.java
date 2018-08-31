package hello;

import java.util.Scanner;

public class ControlStructures {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
	
		//Exercise 1
		/*for(int i = 1; i <= 10; i++) {
			System.out.print(i + ",");
		}*/
		
		//Exercise 2
		/*int num1 = 0, num2 = 1;
		System.out.print(num1 + "," + num2 + ",");
		
		for(int i = 2; i <= 9; i++) {
			int num3;
			num3 = num1 + num2;
			System.out.print(num3 + ",");
			num1 = num2;
			num2 = num3;
		}*/
		
		//Exercise 3
		/*for(int i = 1, num = 0; i <= 6; i++) {
			num += i;
			System.out.println(num);
		}*/
		
		//Exercise 4
		/*String ans = "";
		boolean cont = false;
		do {
			System.out.print("Input 1st number:");
			int num1 = input.nextInt();
			
			System.out.print("Input 2nd number:");
			int num2 = input.nextInt();
			int num3 = num1 <= num2 ? num1 : num2;
			int num4 = num1 >= num2 ? num1 : num2;
			
			if(num1 % num2 == 0) {
				System.out.println("The greatest common factor is: " + num1);
			} else {
				for(int i = num3/2; i >= 1 ; i--) {
					if(num4 % i == 0 && num3  % i == 0) {
						System.out.println("The greatest common factor is: " + i);
						break;
					}
				}
			}
			
			System.out.println("------------------------------");
			System.out.println("Do you want to try again?(Y/N): ");
			ans = input.next();
			if(ans.equals("Y") || ans.equals("y")) {
				cont = true;
			} else {
				cont = false;
			}
		} while(cont);
		input.close();*/
		
		//Exercise 5
		/*for(int i = 1; i <= 10; ++i)
	    {
	        for(int j = 1; j <= i; ++j)
	        {
	            System.out.print(j);
	        }
	        System.out.println();
	    }*/
		
		//Exercise 4 (Yesterday)
		/*args = new String[3];
		System.out.println("Enter command line arguments:");
		for (int i = 0; i < args.length; i++) {
	        args[i] = input.next();
	    }
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		int ans;
		switch(args[2]) {
			case "+":
				ans = num1 + num2;
				System.out.println("Answer is: " + ans);
				break;
			case "-":
				ans = num1 - num2;
				System.out.println("Answer is: " + ans);
				break;
			case "*":
				ans = num1 * num2;
				System.out.println("Answer is: " + ans);
				break;
			case "/":
				ans = num1 / num2;
				System.out.println("Answer is: " + ans);
				break;
			default:
				System.out.println("Wrong input");
		}*/
		
		//Exercise 5 (Yesterday)
		
		/*boolean cont = false;
		int counter = 0;
		do {
			System.out.print("Input number:");
			int num = input.nextInt();
			int secretNumber = (int)(Math.random()*100);
			
			if(num > secretNumber) {
				System.out.println("Try lower");
				counter++;
				cont = true;
			} else if ( num < secretNumber) {
				System.out.println("Try higher");
				counter++;
				cont = true;
			} else {
				++counter;
				System.out.println("You did it in " + counter + " trials.");
				cont = false;
			}
		} while(cont);
		input.close();*/
		
	}
}
