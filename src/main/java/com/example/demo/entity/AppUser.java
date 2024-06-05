package com.example.demo.entity;

import com.example.demo.dto.BaseDoc;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity(name = "app_user")
public class AppUser extends BaseDoc {
    private String name;
    private String mobileNo;
    private String email;
    private String password;
}
