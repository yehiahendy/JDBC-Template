package com.example.jdbc5.service;

import com.example.jdbc5.model.Employee;
import com.example.jdbc5.repository.EmployeeReoImp;
import com.example.jdbc5.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public int getEmployeesCount() {
        return employeeRepository.count();
    }

    public Employee findEmployeeById(long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public int addNewEmployee(Employee employee) {
        return employeeRepository.insert(employee.getName(), employee.getSalary());
    }

    public int updateEmployee(Employee employee) {
        return employeeRepository.update(employee);
    }

    public int deleteEmployee(long id) {
        return employeeRepository.delete(id);
    }

}
