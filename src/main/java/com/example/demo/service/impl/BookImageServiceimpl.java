package com.example.demo.service.impl;

import com.example.demo.dto.GenericResponse;
import com.example.demo.entity.Book;
import com.example.demo.repo.BookRepo;
import com.example.demo.service.BookImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class BookImageServiceimpl implements BookImageService {
    @Autowired
    BookRepo bookRepo;

    @Override
    public byte[] storeFile(MultipartFile file) throws IOException {
//        Book fileStorage = new Book();
//        fileStorage.setBookImage(file.getBytes());
//        bookRepo.save(fileStorage);
//        return fileStorage.getBookImage() ;
        return null;
    }
}