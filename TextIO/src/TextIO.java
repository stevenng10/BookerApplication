import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class TextIO {

	private static Logger log = Logger.getLogger(TextIO.class);
	
	public static void main(String[] args) {
		File groceries = new File("groceries.txt");
		File output = new File("receipt.txt");
		
		try {
			PrintWriter pw1 = new PrintWriter(groceries);
			pw1.println("apple|2|2.99");
			pw1.println("bread|3|5.98");
			pw1.println("milk|4|1.79");
			pw1.close();
			
			FileWriter fw = new FileWriter(output, true); // true is a boolean value, not a variable
			PrintWriter pw2 = new PrintWriter(fw);
		
			String[] lines = null;
			Scanner in = new Scanner(groceries);
			
			double sum = 0;
		
			while(in.hasNext()) {
				lines = in.nextLine().split("\\|");
				sum += (Double.parseDouble(lines[1]) * Double.parseDouble(lines[2]));
				log.info(sum);
			}
			log.debug("debug message");
			//pw2.printf("Total grocery bill: $%.2f", sum);
			
			pw2.close();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
