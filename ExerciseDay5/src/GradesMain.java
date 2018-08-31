import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradesMain {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please input a grade: ");
		double score = in.nextDouble();
		
		StudentGrader stud = new StudentGrader();
		StringMessenger st = new StringMessenger();
		System.out.println(st.getMessage(stud.printScoreEquivalent(score)));
		
		List<String> myList = new ArrayList<String>();

	}
}
