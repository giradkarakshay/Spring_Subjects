/**
 * 
 */
package com.yash.dao;

import java.util.List;

import com.yash.domain.Employee;

/**
 * @author akshay.giradkar
 *
 */
public interface EmployeeDao {

	List<Employee> getEmployeeList();

	void insertEmployee(Employee employee);

	public int deleteEmployee(Integer employeeId);

	public Employee updateEmployee(Employee employee);
	
	public Employee getEmployee(int employeeid);

}
