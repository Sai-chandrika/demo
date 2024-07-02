package com.example.demo.dto;

import com.example.demo.entity.Category;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDto {
    private String id;
    private String name;
    private String author;
    private String category;
    private double prize;
    private int count;
    private String bookImage;
}
