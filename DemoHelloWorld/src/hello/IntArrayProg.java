package hello;

import java.util.Scanner;

public class IntArrayProg {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		boolean continue_ = true;
		int[] storedValues = new int[5];
		
		while(continue_) {
			
			System.out.println("*********************************");
			System.out.println("* A) [Store]: (An Integer)\t*");
			System.out.println("* B) [Print]: (What you stored)\t*");
			System.out.println("* C) [Sort]: (Numbers)\t\t*");
			System.out.println("* D) [Search]: (Values)\t\t*");
			System.out.println("* E) [Exit]\t\t\t*");
			System.out.println("*********************************");
			System.out.println("Answer:");
			
			String choice = input.nextLine().toUpperCase();
			
			switch(choice) {
			
				case "A" : 
					System.out.println("Store Values:");
					for (int i = 0; i < storedValues.length; i++) {
						storedValues[i] = input.nextInt();
				    }
					System.out.println("-------------------------------");
					continue_ = true;
					break;
				case "B" :  
					System.out.println("Print Values: ");
					for (int i = 0; i < storedValues.length; i++) {
						System.out.print(storedValues[i] + ", ");
					}
					System.out.println();
					System.out.println("-------------------------------");
					continue_ = true;
					break;
				case "C" : 
					System.out.println("Sort: ");
					for(int i = 0; i < storedValues.length; i++){
						for(int j=i+1; j< storedValues.length; j++)
						{ 
							if(storedValues[i]> storedValues[j])
							{ 
								int temp = storedValues[i]; 
								storedValues[i]=storedValues[j]; 
								storedValues[j]=temp; 
							} 
						} 
					}
					System.out.println();
					System.out.println("-------------------------------");
					continue_ = true;
					break;
				case "D" : 
					System.out.println("Search a number:");
					int searchNum = input.nextInt();
					for(int i = 0; i < storedValues.length; i++){
						
						if(storedValues[i] == searchNum) {
							System.out.println("Found number at: index " + i);
						} 	
						
					}
					continue_ = true;
					break;
				case "E":
					continue_ = false;
					break;
				default: System.out.println("Not within the choices.");
					continue_ = true;
					break;
			}
			
		}
		input.close();
	}
}
