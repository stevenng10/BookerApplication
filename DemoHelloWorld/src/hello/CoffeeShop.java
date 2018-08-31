
package hello;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CoffeeShop {
	
	Scanner input;
	
	int totalCost;
	int change;
	String code;
	int quant;

	ArrayList<String> productNames = new ArrayList<String>();
	ArrayList<String> productCode = new ArrayList<String>();
	ArrayList<Integer> orderPrices = new ArrayList<Integer>();
	
	ArrayList<String> orderProductName = new ArrayList<String>();
	ArrayList<Integer> orderProductQuantity = new ArrayList<Integer>();
	ArrayList<Integer> orderOrderPrice = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		CoffeeShop cs = new CoffeeShop();
		
		cs.initializeArrays();
		cs.input = new Scanner(System.in);
		
		System.out.print("\t~~~~~~~~~~~~~~~~ MENU ~~~~~~~~~~~~~~~~~~~\n");
		System.out.println("  PRODUCT CODE\t\tPRODUCT NAME\t\tPRICE");
		System.out.println("\tA\t\tAmericano Tall\t\t100");
		System.out.println("\tB\t\tAmericano Venti\t\t120");
		System.out.println("\tC\t\tAmericano Grande\t140");
		System.out.println("\tD\t\tFrappe Tall\t\t110");
		System.out.println("\tE\t\tFrappe Venti\t\t130");
		System.out.println("\tF\t\tFrappe Grande\t\t150");
		System.out.println("\tG\t\tLatte Tall\t\t105");
		System.out.println("\tH\t\tLatte Venti\t\t145");
		System.out.println("\tI\t\tLatte Grande\t\t175");
		
		boolean cont = false;
		cs.totalCost = 0;
		String prodCode = " ";
		int quantity = 0;
		
		do {
			prodCode = cs.catchCode().toUpperCase();
			
			quantity = cs.catchQuantity();
			
			//Computing Method
			cs.totalCost(prodCode, quantity);
			System.out.println("Your total expenses are " + cs.totalCost);
			System.out.println("Would you like to order something else? Y/N or press any key to cancel order.");
			String reply = cs.input.next();
			if(reply.equalsIgnoreCase("Y")) {
				cont = true;
			}
			else if(reply.equalsIgnoreCase("N")) {
				cont = false;
			}
			else {
				System.out.println("Order cancelled.");
				System.exit(0);
			}
			cs.input.nextLine();
		}while(cont);
		cs.printArray();
		do{
			System.out.println("Total Price: " + cs.totalCost);
			System.out.print("Please input your payment(PHP): ");
			System.out.println("(Or press any letter to cancel)");
			int amount = 0;
			try{
				amount = cs.input.nextInt();
			}
			catch(InputMismatchException ime) {
				System.out.println("Order cancelled.");
				System.exit(0);
			}
			cont = cs.payment(amount);
		}while(cont);
		System.out.println("Change: " + cs.change);
		cs.input.close();
	}
	
	void initializeArrays() {
		productNames.add("Americano Tall");
		productNames.add("Americano Venti");
		productNames.add("Americano Grande");
		productNames.add("Frappe Tall");
		productNames.add("Frappe Venti");
		productNames.add("Frappe Grande");
		productNames.add("Latte Tall");
		productNames.add("Latte Venti");
		productNames.add("Latte Grande");
		
		productCode.add("A");
		productCode.add("B");
		productCode.add("C");
		productCode.add("D");
		productCode.add("E");
		productCode.add("F");
		productCode.add("G");
		productCode.add("H");
		productCode.add("I");
		
		orderPrices.add(100);
		orderPrices.add(120);
		orderPrices.add(140);
		orderPrices.add(110);
		orderPrices.add(130);
		orderPrices.add(150);
		orderPrices.add(105);
		orderPrices.add(145);
		orderPrices.add(175);
	}
	
	public void totalCost(String coffeeCode, int quantity){
		int index = productCode.indexOf(coffeeCode);
		
		//Update orderProductName
		orderProductName.add(productNames.get(index));
		orderProductQuantity.add(quantity);
		//orderOrderPrice.add(orderPrices.get(index));
		
		int lastOrder = orderProductName.size() - 1;
		//totalCost += orderProductQuantity.get(lastOrder) * orderOrderPrice.get(lastOrder);

		//New
		int fullOrderPrice = orderProductQuantity.get(lastOrder) * orderPrices.get(index);
		orderOrderPrice.add(fullOrderPrice);
		
		totalCost += fullOrderPrice;
	}
	
	public void printArray(){
		for (int i = 0; i < orderProductName.size(); i++) {
			System.out.print(orderProductName.get(i) + "\t");
		}
		System.out.println();
		
		for (int i = 0; i < orderProductQuantity.size(); i++) {
			System.out.print(orderProductQuantity.get(i) + "\t");
		}
		System.out.println();
		
		for (int i = 0; i < orderOrderPrice.size(); i++) {
			System.out.print(orderOrderPrice.get(i) + "\t");
		}
		System.out.println();
	}

	public boolean payment(int amount) {
		
		if(totalCost > amount) {
			System.out.println("Insufficient funds.");
			return true;
		} else {
			change = amount - totalCost;
			return false;
		}
	}
	
	public String catchCode() {
		System.out.print("Please input the product code: ");
		try {
			code = input.next();
			if(code.matches("[a-iA-I]")) {
				return code;
			}
			else {
				throw new InputMismatchException();
			}
		}
		catch(InputMismatchException ime) {
			System.out.println("Invalid Input");
			catchCode();
		}
		return code;
	}
	
	public int catchQuantity() {
		System.out.print("Please input the quantity: ");
		try {
			quant = input.nextInt();
		}
		catch(InputMismatchException ime) {
			System.out.println("Invalid Input");
			input.nextLine();
			catchQuantity();
		}
		return quant;
	}
}
