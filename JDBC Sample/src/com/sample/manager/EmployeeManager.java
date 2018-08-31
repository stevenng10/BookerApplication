package com.sample.manager;

import java.util.List;

import com.sample.beans.Employee;
import com.sample.dao.EmployeeDao;

public class EmployeeManager {

	public List<Employee> getEmployees() {
		EmployeeDao empDao = new EmployeeDao();
		return empDao.getEmployees();
	}

	public Employee getEmployee(String employeeNumber) {
		EmployeeDao empDao = new EmployeeDao();
		return empDao.getEmployeesByEmployeeNumber(employeeNumber);
	}
}
