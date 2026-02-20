package com.techouts.jpa.controller;

import com.techouts.jpa.model.Employee;
import com.techouts.jpa.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping("/add")
    public String addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return "employee added successfully";
    }
    @PostMapping("/update/{id}")
    public String  updateEmployee(@PathVariable int id,@RequestBody Employee employee) {
        employeeService.updateEmployee(id,employee);
        return "employee updated successfully";
    }
    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return "employee deleted successfully";
    }
}
