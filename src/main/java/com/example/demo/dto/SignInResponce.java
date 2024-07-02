package com.example.demo.dto;

import com.example.demo.enums.Role;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class SignInResponce {
    private Role role;
    private String token;
}
