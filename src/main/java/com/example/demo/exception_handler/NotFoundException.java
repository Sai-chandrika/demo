package com.example.demo.exception_handler;

public class NotFoundException extends  RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
