package com.yash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yash.domain.Employee;
import com.yash.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@RequestMapping(value = "/employeelist.ds", method = RequestMethod.GET)
	public List<Employee> showEmployeeList() {

		return service.allemployeeList();

	}

	@RequestMapping(value = "/addemployee.ds", method = RequestMethod.POST)
	void addEmployees(@RequestBody Employee employee) {
		System.out.println("in controller " + employee);
		service.addEmployee(employee);

	}

	@RequestMapping(value = "/deleteemployee/{id}.ds", method = RequestMethod.DELETE)
	void deleteEmployees(@PathVariable("id") Integer employeeId) {

		System.out.println("NAHI HUAAAA");
		service.deleteEmployee(employeeId);
		System.out.println("DELETE HUAAAA");

	}

	@RequestMapping(value = "/update.ds", method = RequestMethod.PUT)
	void updateEmployee(@RequestBody Employee employee) {

		System.out.println("UPdate pending");
		service.updateEmployee(employee);
		System.out.println("UPdate Done");

	}

	@RequestMapping(value = "/search/{id}.ds", method = RequestMethod.GET)
	public ResponseEntity<Employee> searchEmployee(@PathVariable("id") int employeeId) {

		System.out.println("Search pending");
		Employee emp = service.getEmployee(employeeId);
		System.out.println("Search Done");
		if(emp!=null) {
			return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}

	}
}
