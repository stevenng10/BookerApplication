package hello;

import java.util.Scanner;

public class ExerciseHard {

public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		boolean continue_ = false;
		int[] storedValues = new int[5];
		int chance = 0;
		
		do {	
			
			System.out.print("Input a number from 1 to 20 or choose to type (I give up): ");
			String user_input = input.nextLine();
			
			int randomNum = (int)(Math.random()*20);
	
			if(user_input.equals("I give up")) {
				
				System.out.println("Aww.. Oh well.. Here’s the number: " + randomNum);
				continue_ = false;
				
			} else {
				
				boolean isValid = true;
				
				for(int i = 0; i < user_input.length(); i++) {
					
					if(user_input.charAt(i) <= 48 || user_input.charAt(i) > 57) {
						
						System.out.println("Please input valid number.");
						continue_ = true;
						isValid = false;
						break;
					}
				}
				
				if(isValid) {
					
					int num = Integer.parseInt(user_input);
					
					if(num <= 0 || num > 20) {
						
						System.out.println("Please input a number that is within range.");
						continue_ = true;
						
					} else {
						
						boolean isUnique = true;
						for(int i = 0; i < storedValues.length; i++){
							
							if(storedValues[i] == num) {
								isUnique = false;
								continue_ = false;
							} 	
						}
						
						if(!isUnique) {
							System.out.println("You tried that number already!!");
						} else {
							storedValues[chance] = num;
							
						}
						
						if(num == randomNum) {
							
							System.out.println("Congrats! You won!");
							System.out.println("You did it in " + (5-chance) + " tries!");
							continue_ = false;
							
						} else {
							
							if(chance != 4) {
								
								System.out.println("Wrong! You haven’t guessed the number!");
								continue_ = true;
								
							} else {
								
								System.out.println("Wrong! You haven’t guessed the number!");
								System.out.println("Sorry you lost all your chances.");
								continue_ = false;
								
							}
							
						}						
					}
					
				}
			}  
			++chance;
			System.out.println("You still have " + (4-chance) + " tries!");
		} while(continue_ && chance != 5);
		input.close();
	}
}
