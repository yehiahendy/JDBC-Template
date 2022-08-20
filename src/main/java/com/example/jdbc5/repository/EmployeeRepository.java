package com.example.jdbc5.repository;

import com.example.jdbc5.model.Employee;

import java.util.List;


public interface EmployeeRepository {
    int count();

    Employee findById(long id);

    List<Employee> findAll();

    int insert(String name, double salary);
    int update(Employee employee);

    int delete(long id);
}
