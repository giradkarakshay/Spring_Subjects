/**
 * 
 */
package com.yash.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.dao.EmployeeDao;
import com.yash.domain.Employee;
import com.yash.service.EmployeeService;

/**
 * @author akshay.giradkar
 *
 */
@Service("service")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao dao;

	public List<Employee> allemployeeList() {

		return dao.getEmployeeList();
	}

	public void addEmployee(Employee employee) {
		dao.insertEmployee(employee);

	}

	public int deleteEmployee(Integer employeeId) {

		return dao.deleteEmployee(employeeId);

	}

	public Employee updateEmployee(Employee employee) {

		return dao.updateEmployee(employee);
	}

	public Employee getEmployee(int employeeid) {
		
	
		return dao.getEmployee(employeeid);
	}
}
