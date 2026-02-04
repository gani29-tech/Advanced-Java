package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//One to Many Example
@Entity
@Table(name="department")
public class Department {
	@Id
	@Column(name ="department_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	@Column(name ="department_name")
	String name;
	@OneToMany(mappedBy="department1",cascade = CascadeType.ALL)
	List<Student> students = new ArrayList<>();
		
	public int getId() {
		return id;
	}
	public Department() {}
	public Department(String name) {
		this.name = name;
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
	public List<Student> getStudents() {
		return students;
	}
	public void addStudents(Student stud) {
			students.add(stud);
			stud.setDepartment(this);
	}
	
}
