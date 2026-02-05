
package com.techouts;
import jakarta.persistence.*;
@Entity
@Table(name="employee")
public class Employee {
	@Id
	@Column(name="employee_id")
	private int id;
	@Column(name="employee_name")
	private String name;
	@Column(name="employee_salary")
	private double salary;
	public String getName() {
		return name;
	}
	@ManyToOne
	@JoinColumn(name="user_username")
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Employee() {}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
