
public class StringMessenger {
	
	public String getMessage(String letter) {
		if(letter.equals("A")) {
			return "Perfect";
		} else if(letter.equals("B")) {
			return "Wonderful";
		} else if(letter.equals("C")) {
			return "Fair";
		} else if(letter.equals("D")) {
			return "Oh no!";
		} else {
			return "You're truncated.";
		}
	}
}
