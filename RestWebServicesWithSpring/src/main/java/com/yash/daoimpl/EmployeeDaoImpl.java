/**
 * 
 */
package com.yash.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yash.dao.EmployeeDao;
import com.yash.domain.Employee;

/**
 * @author akshay.giradkar
 *
 */
@Repository("dao")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public List<Employee> getEmployeeList() {

		List<Employee> list = new ArrayList<Employee>();
		System.out.println("hibernateTemplate::" + hibernateTemplate);
		list = hibernateTemplate.loadAll(Employee.class);
		System.out.println("In Dao :  " + list);
		for (Employee employee : list) {
			System.out.println(employee);
		}
		return list;

	}

	@Transactional
	public void insertEmployee(Employee employee) {
		System.out.println("in dao " + employee);

		hibernateTemplate.saveOrUpdate(employee);
		// hibernateTemplate.getSessionFactory().openSession().beginTransaction().commit();
		System.out.println("GAYA ...............");
		/*
		 * Employee employee1 = hibernateTemplate.get(Employee.class, employee.getId());
		 */
	}

	@Transactional
	public int deleteEmployee(Integer employeeId) {

		Session session = hibernateTemplate.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();

			Employee employee1 = session.get(Employee.class, employeeId);
			session.delete(employee1);
			System.out.println("deleted...");
			session.getTransaction().commit();
			hibernateTemplate.flush();
			return 1;
		} catch (Exception e) {
			System.out.println("Exception Occured " + e);
		}
		// hibernateTemplate.delete(hibernateTemplate.load(Employee.class, employeeId));
		return 1;

	}

	@Transactional
	public Employee updateEmployee(Employee employee) {

		Session session = hibernateTemplate.getSessionFactory().openSession();

		try {
			session.getTransaction().begin();

			Employee emp = getEmployee(employee.getId());
			emp.setDesignation(employee.getDesignation());
			emp.setEmail(employee.getEmail());
			emp.setName(employee.getName());
			emp.setSalary(employee.getSalary());
			session.update(emp);

			System.out.println("Updated...");
			session.getTransaction().commit();
			hibernateTemplate.flush();
			return employee;
		} catch (Exception e) {
			System.out.println("Exception Occured " + e);
		}
		return employee;

	}

	@Transactional
	public Employee getEmployee(int empid) {
		Session session = hibernateTemplate.getSessionFactory().openSession();

		Employee employeeToBeFound = new Employee();

		try {
			session.getTransaction().begin();

			employeeToBeFound = session.get(Employee.class, empid);

		} catch (Exception e) {

			System.out.println("Exception Occured........." + e);
		}
		return employeeToBeFound;

	}
}
