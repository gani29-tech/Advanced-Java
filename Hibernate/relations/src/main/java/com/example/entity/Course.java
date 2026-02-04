package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "course",uniqueConstraints = @UniqueConstraint(columnNames = "course_name"))
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "course_id")
	private int id;
	@Column(name="course_name")
	private String name;
	public Course() {
	}
	@ManyToMany(mappedBy = "course")
	private List<Student> students = new ArrayList<>();
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Course(String name) {
		this.name = name;
	}
}
