package com.example.demo.dto;

import com.example.demo.enums.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppUserDto {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNo;
    private String address;
    private Role role;
    private String password;
}
