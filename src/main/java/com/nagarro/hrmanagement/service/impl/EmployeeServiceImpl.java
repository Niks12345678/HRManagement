package com.nagarro.hrmanagement.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.supercsv.io.ICsvBeanWriter;

import com.nagarro.hrmanagement.model.Employee;
import com.nagarro.hrmanagement.repository.EmployeeRepository;
import com.nagarro.hrmanagement.service.EmployeeService;
import com.nagarro.hrmanagement.utils.CsvUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public static final String[] BEAN_HEADER = { "employeeCode", "employeeName", "location", "email", "dateOfBirth" };
    public static final String[] DISPLAY_HEADER = { "Employee Code", "Employee Name", "Location", "Email",
            "Date Of Birth" };

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * @return list of employees
     */
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    /**
     * add employee to .csv file
     */
    @Override
    public void addEmployeeDetailsToFile(ICsvBeanWriter csvBeanWriter) throws IOException {
        List<Employee> employees = this.getAllEmployees();
        System.out.println(employees);
        csvBeanWriter.writeHeader(DISPLAY_HEADER);
        for (Employee employee : employees) {
            csvBeanWriter.write(employee, BEAN_HEADER);
        }
    }

    /**
     * add all employees to .csv file
     */
    @Override
    public void addAllEmployees(MultipartFile file) {
        List<Employee> employees = CsvUtil.getParsedData(file);
        if (employees != null) {
            System.out.println("hello....");
            System.out.println(employees);
            employeeRepository.addAllEmployees(employees);
        }
    }

    /**
     * edit an employee
     */
    @Override
    public void editEmployee(Employee employee) {
        employeeRepository.editEmployee(employee);
    }
}
