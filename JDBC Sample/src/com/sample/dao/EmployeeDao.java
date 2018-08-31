package com.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sample.beans.Employee;

public class EmployeeDao {

	public List<Employee> getEmployees() {

		List<Employee> employees = new ArrayList<>();

		ConnectionManager mng = new ConnectionManager();
		Connection conn = mng.connect();

		String query = "select employee_number, firstname, lastname from employees";

		try {

			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {

				Employee emp = new Employee();
				emp.setEmployeeNumber(rs.getString("employee_number"));
				emp.setFirstname(rs.getString("firstname"));
				emp.setLastname(rs.getString("lastname"));

				employees.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employees;
	}

	public Employee getEmployeesByEmployeeNumber(String employeeNumber) {

		ConnectionManager mng = new ConnectionManager();
		Connection conn = mng.connect();

		Employee emp = null;
		String query = "select employee_number, firstname, lastname from employees where employee_number = ?";

		try {

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, employeeNumber);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				emp = new Employee();
				emp.setEmployeeNumber(rs.getString("employee_number"));
				emp.setFirstname(rs.getString("firstname"));
				emp.setLastname(rs.getString("lastname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emp;
	}

	public int addEmployee(Employee employee) {
		int result = 0;
		ConnectionManager connmgr = new ConnectionManager();
		Connection conn = connmgr.connect();

		String sql = "insert into employee(employee_number,firstname,lastname) values (?,?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, employee.getEmployeeNumber());
			ps.setString(2, employee.getFirstname());
			ps.setString(3, employee.getLastname());

			result = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
}
