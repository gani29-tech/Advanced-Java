package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="student_id")
    private int id;
    private String name;
    @Column(name ="student_email",nullable =false,unique=true)
    private String email;
    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department1;
    @ManyToMany
    @JoinTable(name ="student_course",joinColumns = @JoinColumn(name="course_id"),inverseJoinColumns = @JoinColumn(name="student_id"))
    private List<Course> course = new ArrayList<>();

    public Student() {}
    

    public String getEmail() {
		return email;
	}

	public Student( String name, String email,Department department) {
		this.name = name;
		this.email = email;
		this.department1 = department;
	}

	public List<Course> getCourse() {
		return course;
	}


	public void addCourse(Course c) {
		course.add(c);
		c.getStudents().add(this);
	}

	public Department getDepartment() {
		return department1;
	}


	public void setDepartment(Department department) {
		this.department1 = department;
	}


	public void setEmail(String email) {
		this.email = email;
	}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
