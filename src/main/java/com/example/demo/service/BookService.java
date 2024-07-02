package com.example.demo.service;

import com.example.demo.dto.BookDto;
import com.example.demo.dto.GenericResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface BookService {
    GenericResponse save(BookDto bookDto) throws IOException;
}
