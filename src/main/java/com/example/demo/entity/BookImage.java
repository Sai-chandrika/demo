package com.example.demo.entity;

import com.example.demo.dto.BaseDoc;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BookImage extends BaseDoc {
    @Lob
    private byte[] image;
}
