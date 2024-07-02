package com.example.demo.entity;

import com.example.demo.dto.BaseDoc;
import com.example.demo.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AppUser extends BaseDoc {
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNo;
    private String address;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String password;
}
