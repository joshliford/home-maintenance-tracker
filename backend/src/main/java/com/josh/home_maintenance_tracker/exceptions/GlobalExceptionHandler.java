package com.josh.home_maintenance_tracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// marks class as global exception handler
@RestControllerAdvice
public class GlobalExceptionHandler {

    // specifies which exception the method handles
    @ExceptionHandler(ResourceNotFoundException.class)
    // ResponseEntity<?> = wrapper for HTTP responses; <?> = wildcard (response body can be any type)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}
