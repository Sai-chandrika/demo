package com.example.demo.entity;

import com.example.demo.dto.BaseDoc;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseDoc {
    private String categoryName;
}
