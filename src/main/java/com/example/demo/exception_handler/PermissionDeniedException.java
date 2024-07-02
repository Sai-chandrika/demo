package com.example.demo.exception_handler;

public class PermissionDeniedException extends RuntimeException{
    public PermissionDeniedException(String message) {
        super(message);
    }
}
