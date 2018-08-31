package hello;

import java.util.Scanner;

public class Score {

	public static void main(String[] args) {
		// TODO Auto-generated method stub91
		int score = userInput();
		System.out.println(score);
	}

	public static int userInput() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Input a score:");
		int score = in.nextInt();
		
		return score;
	}
}
