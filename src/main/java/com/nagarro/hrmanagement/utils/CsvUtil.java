package com.nagarro.hrmanagement.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.nagarro.hrmanagement.model.Employee;

public class CsvUtil {
    
    /**
     * @param file
     * @return list of employees
     */
    public static List<Employee> getParsedData(MultipartFile file) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String row = null;
            String[] data = null;
            List<Employee> employees = new ArrayList<Employee>();
            Employee employee;
            boolean firstRow = true;
            while ((row = reader.readLine()) != null) {
                if (firstRow) {
                    firstRow = false;
                } else {
                    data = row.split(",");
                    employee = new Employee();
                    employee.setEmployeeCode(Long.valueOf(data[0]));
                    employee.setEmployeeName(data[1]);
                    employee.setLocation(data[2]);
                    employee.setEmail(data[3]);
                    employee.setDateOfBirth(data[4]);
                    employees.add(employee);
                }
            }
            return employees;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
