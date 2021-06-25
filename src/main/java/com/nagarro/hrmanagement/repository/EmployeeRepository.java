package com.nagarro.hrmanagement.repository;

import java.util.List;

import com.nagarro.hrmanagement.model.Employee;

public interface EmployeeRepository {

    /**
     * @return list of all employees
     */
    public List<Employee> getAllEmployees();

    /**
     * add an employee
     * 
     * @param employee
     */
    void addEmployee(Employee employee);

    /**
     * add employees
     * 
     * @param employees
     */
    void addAllEmployees(List<Employee> employees);

    /**
     * edit an employee
     * 
     * @param employee
     */
    void editEmployee(Employee employee);
}
