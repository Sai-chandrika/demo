package com.example.demo.entity;

import com.example.demo.dto.BaseDoc;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity
@Setter
@Getter
@AllArgsConstructor
public class Cart extends BaseDoc {
    @OneToOne(targetEntity = AppUser.class, cascade = CascadeType.MERGE)
    private AppUser appUser;
    private LocalDateTime localDateTime;
    private double totalAmount;
    @OneToMany(targetEntity = Book.class, cascade = CascadeType.MERGE)
    private List<Book> bookList;
}
