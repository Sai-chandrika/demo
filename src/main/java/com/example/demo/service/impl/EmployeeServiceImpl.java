package com.example.demo.service.impl;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;
    @Override
    public String save(Employee employee) {
        Employee newEmployee = new Employee();
        newEmployee.setFirstName(employee.getFirstName());
        newEmployee.setLastname(employee.getLastname());
        newEmployee.setContactNo(employee.getContactNo());
        newEmployee.setLocation(employee.getLocation());
        newEmployee.setJoiningDate(employee.getJoiningDate());
        employeeRepo.save(newEmployee);
        return "save successfully";
    }
}
