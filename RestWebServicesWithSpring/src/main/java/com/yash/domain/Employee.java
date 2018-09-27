/**
 * 
 */
package com.yash.domain;

import javax.persistence.*;

/**
 * @author akshay.giradkar
 *
 */
@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "designation")
	private String designation;

	@Column(name = "salary")
	private int salary;

	@Column(name = "email")
	private String email;

	public Employee() {

	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + ", salary=" + salary
				+ ", email=" + email + "]";
	}

	public Employee(int id, String name, String designation, int salary, String email) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
