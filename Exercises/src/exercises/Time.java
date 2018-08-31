package exercises;

public class Time {
	
	public int hour;
	public int minute;
	
	String hourVal = hour > 1 ? "hours" : "hour";
	String minVal = minute > 1 ? "minutes" : "minute";
	
	Time(int hour, int minute){
		this.hour = hour;
		this.minute = minute;
	}
	
	public void displayTime() {

		System.out.println(hour + " " + hourVal + ": " + minute + " " + minVal);
	}
	
	public void displayMinute() {
		
		int sum = (60 * hour) + minute;
		
		System.out.println(sum + " minutes");
		
	}

	public void addTime(Time current, Time past) {
		
		int totalHour = current.hour + past.hour;
		int totalMin = current.minute + past.minute;
		
		 if(totalMin % 60 >= 1) {
	         totalHour += totalMin/60;
	         totalMin = totalMin - 60;    
	     } 
		 
		String totalHourVal = totalHour > 1 ? "hours" : "hour";
		String totalMinVal = totalMin > 1 ? "minutes" : "minute";
		
		 System.out.println(totalHour + " " + totalHourVal + ": " + totalMin + " " + minVal);
	}
}
