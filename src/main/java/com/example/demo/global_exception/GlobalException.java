package com.example.demo.global_exception;

import com.example.demo.dto.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<GenericResponse> handleExceptions(
            Exception ex,
            WebRequest request
    ) {
        if (ex instanceof RuntimeException) {
            return composeMethodNotSupportedException(ex, request);
        } else {
            return composeGenericException(ex, request);
        }
    }

    private ResponseEntity<GenericResponse> composeMethodNotSupportedException(Exception ex, WebRequest request) {
        return new ResponseEntity<GenericResponse>(composeApiResponse(ex.getMessage(), 405, request.getDescription(true)), HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<GenericResponse> composeGenericException(Exception ex, WebRequest request) {
        return new ResponseEntity<GenericResponse>(composeApiResponse(ex.getMessage(), 401, request.getDescription(true)), HttpStatus.UNAUTHORIZED);
    }


    private GenericResponse composeApiResponse(String message, int code, String payLoad) {
        return new GenericResponse(code, payLoad,message);
    }
}
