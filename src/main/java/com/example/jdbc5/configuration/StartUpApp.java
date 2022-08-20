package com.example.jdbc5.configuration;

import com.example.jdbc5.model.Employee;
import com.example.jdbc5.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class StartUpApp implements CommandLineRunner {
    private final JdbcTemplate jdbcTemplate;
    private final EmployeeService employeeService;

    public StartUpApp(JdbcTemplate jdbcTemplate, EmployeeService employeeService) {
        this.jdbcTemplate = jdbcTemplate;
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        jdbcTemplate.execute("DROP TABLE  IF EXISTS employees");
        jdbcTemplate.execute("CREATE TABLE employees( id INTEGER NOT NULL AUTO_INCREMENT, name  VARCHAR(255) , salary NUMERIC(15,2),PRIMARY KEY (id))");

       if (employeeService.getEmployeesCount() == 0)
       {
           employeeService.addNewEmployee(new Employee("Yehia Hendy",250L));
           employeeService.addNewEmployee(new Employee("Tefa",250L));
           employeeService.addNewEmployee(new Employee("Reda",250L));
           employeeService.addNewEmployee(new Employee("Nour Apple",250L));

       }
    }
}
