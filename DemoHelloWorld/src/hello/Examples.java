package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Examples {
	
	static List<Integer> orderTotal = new ArrayList<>();
	static List<Integer> productQuantity = new ArrayList<>();
	static List<String> productName = new ArrayList<>();
	
	static int totalCost;
	static int change;

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		orderTotal.add(1120);
		orderTotal.add(130);
		orderTotal.add(900);

		productQuantity.add(1);
		productQuantity.add(5);
		productQuantity.add(4);

		productName.add("x");
		productName.add("y");
		productName.add("z");
		
		System.out.println("How much money do you have?");
		int moneyPaid = in.nextInt();
		output(moneyPaid);
		
	}
	
	private static boolean output(int moneyPaid) {
		
		int sum = 0;
		change = 0;
		
		for(int i = 0; i < productName.size(); i++) {
			sum += orderTotal.get(i);
		}
		
		if(sum > moneyPaid) {
			System.out.println("Insufficient funds.");
			return true;
		} else {
			change = moneyPaid - sum;
			printOutput(change);
			return false;
		}
	}
	
	private static void printOutput(int change) {
		
		System.out.println("--------------Receipt--------------");
		
		System.out.println("Product Name    Product Quantity     Order Total");
		for(int i = 0; i < productName.size(); i++) {
			System.out.println(productName.get(i) + "      "
					+ productQuantity.get(i) + "      " + orderTotal.get(i));
		}
		
		System.out.println("Change: " + change);
	}
}
