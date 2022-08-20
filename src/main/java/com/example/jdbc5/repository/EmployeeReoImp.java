package com.example.jdbc5.repository;

import com.example.jdbc5.mappers.EmployeeMapper;
import com.example.jdbc5.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeReoImp implements EmployeeRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM employees", Integer.class);
    }


    public Employee findById(long id) {
        return jdbcTemplate.queryForObject("SELECT id, name, salary FROM employees WHERE id = ? ",
                new EmployeeMapper(), id);
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query("SELECT * FROM employees ",new EmployeeMapper());
    }

    @Override
    public int insert(String name, double salary) {
        return jdbcTemplate.update("INSERT INTO employees (name ,salary) VALUES (?,?)", name,salary);
    }

    @Override
    public int update(Employee employee) {
        return jdbcTemplate.update("UPDATE employees SET name  = ? , salary = ? WHERE  id =  ?" , employee.getName(),employee.getSalary(),employee.getId());
    }

    @Override
    public int delete(long id) {
       return jdbcTemplate.update("DELETE FROM employees WHERE  id = ?" , id);
    }
}
