package com.example.demo.dto;

import com.example.demo.entity.Category;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookResponse {
    private String id;
    private String name;
    private String author;
    private Category category;
    private double prize;
    private int count;
    private String bookImage;
}
