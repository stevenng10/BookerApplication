package hello;

public class ObjectTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employeee[] empArray = new Employeee[3];
		Employeee emp1 = new Employeee();
		Employeee emp2 = new Employeee();
		Employeee emp3 = new Employeee();
		
		emp1.id = 1;
		emp1.department = "Production";
		emp1.jobTitle = "Developer";
		emp1.name = "Aklas";
		emp1.salary = 30000d;
		
		empArray[0] = emp1;
		
		emp2.id = 2;
		emp2.department = "HR";
		emp2.jobTitle = "Hiring Manager";
		emp2.name = "Boi Utol";
		emp2.salary = 27800.92d;
		
		empArray[1] = emp2;
		
		emp3.id = 3;
		emp3.department = "IT";
		emp3.jobTitle = "contractual";
		emp3.name = "Totoy Losyang";
		emp3.salary = 9000d;
		
		empArray[2] = emp3;
		
		printEmployee(empArray);
		
		empArray[0].increaseSalary(20000);
		empArray[1].increaseSalary(20000);
		empArray[2].increaseSalary(20000);
		
		printEmployee(empArray);
		
		//Employeee.increaseSalary(0);
		
		Employeee.greet();
		
		for(Employeee employee: empArray) {
			
			employee.isPaidByTheHour();	
			
		}
		
		System.out.println(Employeee.numberOfEmployees);
	}
	
	public static void printEmployee(Employeee[] empArray) {
		
		for(Employeee employee: empArray) {
			
			System.out.println(employee.id);
			System.out.println(employee.department);
			System.out.println(employee.jobTitle);
			System.out.println(employee.name);
			System.out.println(employee.salary);	
			
		}
	}
}
