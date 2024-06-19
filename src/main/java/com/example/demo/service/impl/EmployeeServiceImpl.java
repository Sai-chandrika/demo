package com.example.demo.service.impl;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.enums.Role;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public EmployeeDto update(String id, EmployeeDto employeeDto){
        Optional<Employee> employee=employeeRepo.findById(id);
        Employee employee1=new Employee();
        if(employee.isPresent()){
            employee1=employee.get();
            if(employeeDto.getRole()!=null) {
                employee1.setRole(Role.valueOf(employeeDto.getRole()));
            }else{
                employee1.setRole(employee1.getRole());
            }
            if(employeeDto.getFirstName()!=null) {
                employee1.setFirstName(employeeDto.getFirstName());
            }else{
                employee1.setFirstName(employee1.getFirstName());
            }
            if(employeeDto.getLastname()!=null){
            employee1.setLastname(employeeDto.getLastname());
            }else{
                employee1.setLastname(employee1.getLastname());
            }
            if(employeeDto.getContactNo()!=null) {
                employee1.setContactNo(employeeDto.getContactNo());
            }else{
                employee1.setContactNo(employee1.getContactNo());
            }
            if(employeeDto.getLocation()!=null) {
            employee1.setLocation(employeeDto.getLocation());
            }else{
                employee1.setLocation(employee1.getLocation());
            }
            if(employeeDto.getJoiningDate()!=null) {
            employee1.setJoiningDate(employeeDto.getJoiningDate());
            }
            else{
                employee1.setJoiningDate(employee1.getJoiningDate());
            }

            if(employeeDto.getEmail()!=null) {
            employee1.setEmail(employeeDto.getEmail()); }
            else{
                employee1.setEmail(employee1.getEmail()); }

            if(employeeDto.getPassword()!=null) {
            employee1.setPassword(employeeDto.getPassword());
            }
            else{
                employee1.setPassword(employee1.getPassword());
            }


        }else{
              throw new
                      RuntimeException("person id not found");
        }

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
