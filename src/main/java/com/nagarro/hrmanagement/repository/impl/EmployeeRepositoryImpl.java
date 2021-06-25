package com.nagarro.hrmanagement.repository.impl;

import com.nagarro.hrmanagement.model.Employee;
import com.nagarro.hrmanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static final String HTTP_LOCALHOST_8080_EMPLOYEE_API_EMPLOYEES = "http://localhost:8080/employee-api/employees/";
    @Autowired
    private RestTemplate restTemplate;

    /**
     * @return list of employees
     */
    @Override
    public List<Employee> getAllEmployees() {
        ResponseEntity<Employee[]> response = restTemplate.getForEntity(HTTP_LOCALHOST_8080_EMPLOYEE_API_EMPLOYEES,
                Employee[].class);
        Employee[] employees = response.getBody();
        return Arrays.asList(employees);
    }

    /**
     * Add an employee
     */
    @Override
    public void addEmployee(Employee employee) {
        String url = HTTP_LOCALHOST_8080_EMPLOYEE_API_EMPLOYEES;
        restTemplate.postForObject(url, employee, Employee.class);
    }

    /**
     * add employees
     */
    @Override
    public void addAllEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee.getEmployeeCode() + " " + employee.getEmployeeName());
            this.addEmployee(employee);
        }
    }

    /**
     * edit an employee
     */
    @Override
    public void editEmployee(Employee employee) {
        String url = HTTP_LOCALHOST_8080_EMPLOYEE_API_EMPLOYEES + employee.getEmployeeCode();
        System.out.println(url);
        restTemplate.put(url, employee);
    }
}
