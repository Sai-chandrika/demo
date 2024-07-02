package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface BookImageService {
    byte[] storeFile(MultipartFile file) throws IOException;
}
