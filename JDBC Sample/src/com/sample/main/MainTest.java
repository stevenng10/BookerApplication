package com.sample.main;

import com.sample.beans.Employee;
import com.sample.manager.EmployeeManager;

public class MainTest {

	public static void main(String[] args) {

		EmployeeManager mng = new EmployeeManager();
		/*
		 * List<Employee> emps = mng.getEmployees();
		 * 
		 * for (Employee emp : emps) { System.out.println("EMP NUMBER: " +
		 * emp.getEmployeeNumber()); System.out.println("FIRST NAME: " +
		 * emp.getFirstname()); System.out.println("LAST NAME: " + emp.getLastname());
		 * System.out.println("---------------------------------"); }
		 */
		String employeeNumber = "12001";
		Employee emp = mng.getEmployee(employeeNumber);
		System.out.println("EMP NUMBER: " + emp.getEmployeeNumber());
		System.out.println("FIRST NAME: " + emp.getFirstname());
		System.out.println("LAST NAME: " + emp.getLastname());

		/*
		 * Employee emp = new Employee(); emp.setEmployeeNumber("US1001");
		 * emp.setFirstname("steve"); emp.setLastname("ng"); int result =
		 * mng.addEmployee(emp);
		 * 
		 * System.out.println("Rows affected: " + result);
		 */
	}

}
