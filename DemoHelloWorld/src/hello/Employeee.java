package hello;

public class Employeee {
	
	public int id;
	public String name;
	public String department;
	public String jobTitle;
	public double salary;
	static int numberOfEmployees = 0;
	
	Employeee(){
		numberOfEmployees++;
	}
	
	public void increaseSalary(double amount) {
		salary = salary + amount;
	}
	
	public static void greet() {
		System.out.println("Greetings!");
	}
	
	public boolean isPaidByTheHour() {
		
		if(department.equals("IT") && jobTitle.equals("contractual")) {
			System.out.println(name + " is paid by the hour.");
			return true;
		} else {
			System.out.println(name + " is NOT paid by the hour.");
			return false;
		}		
		
	}
}

