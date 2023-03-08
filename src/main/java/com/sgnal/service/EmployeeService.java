package com.sgnal.service;

import com.sgnal.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class EmployeeService {

    List<Employee> employeeList=new ArrayList<>();

    public void saveEmployee(Employee employee){
        employeeList.add(employee);
    }

    public List<Employee> readAllEmployees(){
        return employeeList;
    }

}
