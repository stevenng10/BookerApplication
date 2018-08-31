package exercises;

public class Holiday {
	private String name;
	private int day;
	private String month;
	
	public Holiday(String name, int day, String month) {
		this.name = name;
		this.day = day;
		this.month = month;
	}
	
	public boolean inSameMonth(Holiday h1, Holiday h2) {
		
		if(h1.month.equals(h2.month)) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public static double avgDate(Holiday[] h1) {
		double sum = 0;
		double avg;
		
		for(int i = 0; i < h1.length; i++) {
			sum += h1[i].day;
		}
		
		avg = sum / h1.length;
		
		return avg;
	}
}
