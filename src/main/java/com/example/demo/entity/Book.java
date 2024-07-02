package com.example.demo.entity;

import com.example.demo.dto.BaseDoc;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book extends BaseDoc {
    private String name;
    private String author;
    @ManyToOne(targetEntity = Category.class, cascade = CascadeType.MERGE)
    private Category category;
    private double prize;
    private int count;
    private String bookImage;

}
