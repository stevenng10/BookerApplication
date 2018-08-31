package com.account.main;

import java.util.Scanner;

import com.account.beans.Account;
import com.account.presentation.*;

public class ProgramMain {

	static boolean isDone = false;
	
	public static void main(String[] args) {
		
		CustomerCreationUI custUI = new CustomerCreationUI();
		Scanner in = new Scanner(System.in);
		int index = 0;
		
		while(!isDone) {
			
			custUI.initializaMenu();
			int choice = in.nextInt();
			

			if(Account.getNumAcc() == 1) {
				switch(choice) {
					case 1: custUI.custInitialize(in);
						index = custUI.getIndex();
						break;
					case 2: DisplayUI display = new DisplayUI();
					display.printAcc();
					break;
					case 3: System.out.println("Thank you for using the system!");
						isDone = true;
						break;
					default: System.out.println("Invalid Input.");
						break;
				}	
			} else {
					switch(choice) {
					case 1: custUI.custInitialize(in);
						index = custUI.getIndex();
						break;
					case 2: WithdrawUI withdraw = new WithdrawUI();
					withdraw.withdrawMoney(in, index);
						break;
					case 3: DepositUI deposit = new DepositUI();
						deposit.depositMoney(in,index);
						break;
					case 4: DisplayUI display = new DisplayUI();
					display.printAcc();
					break;
					case 5: SearchUI search = new SearchUI();
						search.searchPerson(in);
						index = search.getIndex();
						break;
					case 6: System.out.println("Thank you for using the system!");
						isDone = true;
						break;
					default: System.out.println("Invalid Input.");
						break;
				}
			}	
			

		}
	}		
}
