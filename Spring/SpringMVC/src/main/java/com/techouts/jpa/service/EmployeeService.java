package com.techouts.jpa.service;

import com.techouts.jpa.model.Employee;
import com.techouts.jpa.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public void addEmployee(Employee employee) {
      employeeRepo.saveEmployee(employee);
    }
    public void deleteEmployee(int id) {
        employeeRepo.deleteEmployee(id);
    }
    public void updateEmployee(int id,Employee employee) {
        employeeRepo.updateEmployee(id,employee);
    }
}
