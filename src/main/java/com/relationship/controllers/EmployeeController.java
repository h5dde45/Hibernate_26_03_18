package com.relationship.controllers;

import com.relationship.models.Employee;
import com.relationship.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "employees")
    public String listContacts(Model model){
        model.addAttribute("contact", new Employee());
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "employees";
    }
}
