package com.example.demo.entity;

import com.example.demo.dto.BaseDoc;
import com.example.demo.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderStore extends BaseDoc {
    @OneToOne(targetEntity = AppUser.class, cascade = CascadeType.MERGE)
    private AppUser appUser;
    private LocalDateTime localDateTime;
    private double totalAmount;
    private double discount;
    @Enumerated(EnumType.STRING)
    private Status status;
   @OneToMany(targetEntity = Book.class, cascade = CascadeType.MERGE)
    private List<Book> bookList;

}
