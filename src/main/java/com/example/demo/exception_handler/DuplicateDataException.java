package com.example.demo.exception_handler;

public class DuplicateDataException extends RuntimeException{
    public DuplicateDataException(String message) {
        super(message);
    }
}
