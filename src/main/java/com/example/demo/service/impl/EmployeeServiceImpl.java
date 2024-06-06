package com.example.demo.service.impl;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.enums.Role;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;
    @Override
    public EmployeeDto save(EmployeeDto employee) {
       Employee employee1=dtoToEntity(employee);
       employeeRepo.save(employee1);
        return entityToDto(employee1);
    }


    public  EmployeeDto entityToDto(Employee employee){
        EmployeeDto dto=new EmployeeDto();
        dto.setFirstName(employee.getFirstName());
        dto.setLastname(employee.getLastname());
        dto.setContactNo(employee.getContactNo());
        dto.setLocation(employee.getLocation());
        dto.setJoiningDate(employee.getJoiningDate());
        dto.setEmail(employee.getEmail());
        dto.setPassword(employee.getPassword());
        dto.setRole(String.valueOf(employee.getRole()));
        return dto;
    }
    public  Employee dtoToEntity(EmployeeDto employee){
        Employee dto=new Employee();
        dto.setFirstName(employee.getFirstName());
        dto.setLastname(employee.getLastname());
        dto.setContactNo(employee.getContactNo());
        dto.setLocation(employee.getLocation());
        dto.setJoiningDate(employee.getJoiningDate());
        dto.setEmail(employee.getEmail());
        dto.setPassword(employee.getPassword());
        dto.setRole(Role.valueOf(employee.getRole()));
        return dto;
    }
}
