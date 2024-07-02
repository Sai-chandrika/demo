package com.example.demo.controller;

import com.example.demo.dto.BookDto;
import com.example.demo.dto.GenericResponse;
import com.example.demo.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    private  ObjectMapper objectMapper;
    @Autowired
    RestTemplate restTemplate;



    @PostMapping("/save")
    public GenericResponse save(@RequestBody BookDto book) throws IOException {
      return new GenericResponse(bookService.save(book));
    }


    @GetMapping("/fetch")
    public ResponseEntity<byte[]> fetchImage() {
        String imageUrl = "https://img.freepik.com/free-photo/book-composition-with-open-book_23-2147690555.jpg";
        ResponseEntity<byte[]> response = restTemplate.getForEntity(imageUrl, byte[].class);
        if (response.getStatusCode() == HttpStatus.OK) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            headers.setContentLength(response.getBody().length);
            return new ResponseEntity<>(response.getBody(), headers, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
