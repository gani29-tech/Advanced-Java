package com.techouts;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
	@Id
	@Column(name="user_name",nullable=false,unique=true)
	private String username;
	@Column(nullable=false)
	private String password;
	@OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL,orphanRemoval = true)
	List<Employee> employees = new ArrayList<>();
	public List<Employee> getEmployees() {
		return employees;
	}
	public void addEmployee(Employee emp) {
		emp.setUser(this);
		employees.add(emp);
	}
	public void removeEmployee(Employee emp) {
		employees.remove(emp);
		emp.setUser(null);
	}
	public void updateEmployee(int id) {
		for(Employee e: employees) {
			if(id==e.getId()) {
			}
		}
	}
	public User() {
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
