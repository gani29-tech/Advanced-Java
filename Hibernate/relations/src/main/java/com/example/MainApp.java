package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Course;
import com.example.entity.Department;
import com.example.entity.Student;

public class MainApp {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        Department dept = new Department("IT");
        Student student1 = new Student("gani", "gani@gmail.com", dept);
        Student student2 = new Student("nani", "nani@gmail.com", dept);
        dept.addStudents(student1);
        dept.addStudents(student2);
        Course course1 = new Course("mapping");
        Course course2 = new Course("AI");
        Course course3 = new Course("Java");
        student1.addCourse(course1);
        student1.addCourse(course3);
        student2.addCourse(course2);
        student2.addCourse(course1);
        student2.addCourse(course3);
        session.persist(course1);
        session.persist(course3);
        session.persist(course2);
        session.persist(dept);
        session.getTransaction().commit();
        session.close();
        factory.close();
        System.out.println("Student saved successfully!");
    }
}
