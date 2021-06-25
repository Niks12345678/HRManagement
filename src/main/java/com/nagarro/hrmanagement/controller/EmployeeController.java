package com.nagarro.hrmanagement.controller;

import com.nagarro.hrmanagement.model.Employee;
import com.nagarro.hrmanagement.model.User;
import com.nagarro.hrmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * @param model
     * @param request
     * @return List of Employees
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getEmployeeListed(Model model, HttpServletRequest request) {
        String response;
        HttpSession httpSession = request.getSession();
        if (httpSession != null && httpSession.getAttribute("userInfo") != null) {
            User user = (User) httpSession.getAttribute("userInfo");
            String userName = user.getName();
            model.addAttribute("userName", userName);
            List<Employee> employees = employeeService.getAllEmployees();
            model.addAttribute("employees", employees);
            response = "Success";
        } else {
            response = "redirect:/login";
        }
        return response;
    }

    /**
     * Upload file and Save data in Database
     * 
     * @param file
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file") MultipartFile file, Model model, HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        if (httpSession != null && httpSession.getAttribute("userInfo") != null) {
            employeeService.addAllEmployees(file);
            return "redirect:/employee";
        }
        return "redirect:/login";
    }

    /**
     * Edit an employee
     * 
     * @param employee
     * @param request
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editEmployee(@ModelAttribute("employee") Employee employee, HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        if (httpSession != null && httpSession.getAttribute("userInfo") != null) {
            System.out.println("hello....");
            System.out.println(employee.getEmployeeCode());
            System.out.println(employee.getEmployeeName());
            System.out.println(employee.getEmail() + " " + employee.getLocation() + " " + employee.getDateOfBirth());
            employeeService.editEmployee(employee);
            return "redirect:/employee";
        }
        System.out.println("outt....");
        return "redirect:/WEB-INF/jsp/login";
    }

    /**
     * download the CSV file
     * 
     * @param response
     * @param request
     */
    @RequestMapping(value = "/download", method = RequestMethod.POST)
    public void downloadFile(HttpServletResponse response, HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        if (httpSession != null && httpSession.getAttribute("userInfo") != null) {
            response.setContentType("text/csv");
            response.addHeader("Content-Disposition", "attachment; filename=" + "EmployeeData.csv");
            try (ICsvBeanWriter csvBeanWriter = new CsvBeanWriter(response.getWriter(),
                    CsvPreference.STANDARD_PREFERENCE)) {
                employeeService.addEmployeeDetailsToFile(csvBeanWriter);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
