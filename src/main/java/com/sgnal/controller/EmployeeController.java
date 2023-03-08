package com.sgnal.controller;


import com.sgnal.bootstrap.DataGenerator;
import com.sgnal.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/register")
    public String create(Model model){

        model.addAttribute("states", DataGenerator.getAllStates());
        model.addAttribute("employee",new Employee());
        return "employee/create";
    }

    @PostMapping("/result")
    public String showEmployees(@ModelAttribute("employee") Employee employee){

        return "employee/result";
    }
}
