package hello;

import java.util.Scanner;

public class SeatPlan {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		boolean continue_ = true;
		
		while(continue_) {
			
			String[][] classLists = 
				{
					{ "Dexter", "Steven", "Allen", "Gceal", "Jam", "MC"},
					{ "Treska", "Rey", "Eric", "Karl", "Josh", "JC"},
					{ "Ken", "Elmer", "Chris", "Erika", "Sij", "Earl"}
				};
			
			printList(classLists);
			
			System.out.println("Search for a name in the class list: ");
			String input = in.nextLine();
			boolean isFound = false;
			int row = 0;
			int col = 0;
			
			for (int i = 0; i < classLists.length; i++) {
			    for (int j = 0; j < classLists[i].length; j++) {
			    	if (classLists[i][j].equals(input)) {
			        	isFound = true;
			        	row = i;
			        	col = j;
			        	break;
			        }
			    }
			}
			
			if(isFound) {
				
				for (int i = 0; i < classLists.length; i++) {
				    for (int j = 0; j < classLists[i].length; j++) {
				    	if (classLists[i][j].equals(input)) {
				    		classLists[i][j] = "**" + input + "**";
				        }
				    }
				}
				
				System.out.println(input + " can be found at row " + 
				(row + 1) + " and column " + (col + 1) + ".");
				printList(classLists);
			} else {
				System.out.println("Person not found.");
			}
			
			System.out.println("Do you want to search again?(Y/N)?");
			String ans = in.nextLine().toUpperCase();
			
			if(ans.equals("Y") || ans.equals("YES")) {
				
			} else {
				System.out.println("Program ended. Bye.");
				continue_ = false;
			}
		}
		in.close();
	}
	
	public static void printList(String[][] classLists) {
		System.out.println("_________________________________");
		for(String[] classList : classLists) {
			for(String seatPlan : classList) {
				System.out.print("");
				System.out.print("|");
				System.out.print(""+ seatPlan + "|");
			}
			System.out.println();
		}
	}
}
