package com.example.jdbc5.controller;

import com.example.jdbc5.model.Employee;
import com.example.jdbc5.repository.EmployeeRepository;
import com.example.jdbc5.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/api/v1/employee"})
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/count")
    public int getEmployeesCount() {
        return employeeService.getEmployeesCount();
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee findEmployeeById(@PathVariable long id) {
        return employeeService.findEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public int deleteEmployeeByID(@PathVariable long id) {
        return employeeService.deleteEmployee(id);
    }

    @PostMapping
    public int addNewEmployee(@RequestBody Employee employee) {
        return employeeService.addNewEmployee(employee);
    }
}
