package com.sgnal.controller;


import com.sgnal.bootstrap.DataGenerator;
import com.sgnal.model.Employee;
import com.sgnal.service.EmployeeService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/register")
    public String create(Model model){

        model.addAttribute("states", DataGenerator.getAllStates());
        model.addAttribute("employee",new Employee());
        return "employee/create";
    }

    @PostMapping("/add")
    public String addEmployees(@ModelAttribute("employee") @Valid Employee employee, BindingResult bindingResult,Model model){
        // We put @Valid annotation in PostMapping method,
        // because user needs to post the data and then we need to check it

        if(bindingResult.hasErrors()){
            model.addAttribute("states", DataGenerator.getAllStates());
            return "/employee/create";
        }
        employeeService.saveEmployee(employee);
        return "redirect:/employee/list"; // with redirect we use endpoints
    }

    @GetMapping("/list")
    public String showEmployees(Model model){
        model.addAttribute("employeeList",employeeService.readAllEmployees());
        return "employee/employee-list";  // without redirect we use html file paths
    }
}
