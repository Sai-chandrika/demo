package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee_project")

public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @PostMapping("/save")
    public String save(@RequestBody Employee employeeProjectDto){

        return employeeService.save(employeeProjectDto);
    }

}
