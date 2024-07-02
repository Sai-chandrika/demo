package com.example.demo.controller;

import com.example.demo.dto.GenericResponse;
import com.example.demo.entity.BookImage;
import com.example.demo.service.BookImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/book-image")
public class BookImageController {
@Autowired
    BookImageService bookImageService;
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        byte[] savedFile =bookImageService .storeFile(file);
            return ResponseEntity.ok("File uploaded successfully! File ID: ");
    }
}
