package com.techouts.jpa.repository;

import com.techouts.jpa.model.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class EmployeeRepo {
    @PersistenceContext
    private EntityManager em;
    @Transactional
    public void saveEmployee(Employee emp) {
        em.persist(emp);
    }
    @Transactional
    public void updateEmployee(int id,Employee employee) {
        Employee emp = em.find(Employee.class, id);
        emp.setName(employee.getName());
        emp.setEmail(employee.getEmail());
        em.merge(emp);
    }
    @Transactional
    public void deleteEmployee(int id) {
        Employee emp = em.find(Employee.class, id);
        em.remove(emp);
    }
}
