/**
 * 
 */
package com.yash.service;

import java.util.List;

import com.yash.domain.Employee;

/**
 * @author akshay.giradkar
 *
 */
public interface EmployeeService {

	List<Employee> allemployeeList();

	void addEmployee(Employee employee);

	public int deleteEmployee(Integer employeeId);

	public Employee updateEmployee(Employee employee);

	public Employee getEmployee(int employeeid);
}
