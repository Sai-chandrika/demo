package com.example.demo.entity;

import com.example.demo.dto.BaseDoc;
import com.example.demo.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Entity(name = "employee")
public class Employee extends BaseDoc {
    private  String firstName;
    private String lastname;
    private String contactNo;
    private String location;
    private Date joiningDate;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role Role;

    public com.example.demo.enums.Role getRole() {
        return Role;
    }

    public void setRole(com.example.demo.enums.Role role) {
        Role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }





}
