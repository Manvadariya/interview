package com.shipmnt.interview.restapi.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> violations = new HashMap<>();

        // Extract field names and their respective error messages
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            violations.put(fieldName, errorMessage);
        });

        ValidationErrorResponse errorBody = new ValidationErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Validation Failed",
                violations
        );

        return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
    }


    // 404 errors
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleNotFound(ResourceNotFoundException e){

        Map<String,Object> mpp = new HashMap<>();

        mpp.put("timestamp", LocalDateTime.now());
        mpp.put("status", HttpStatus.NOT_FOUND.value());
        mpp.put("message", e.getMessage());


        return new ResponseEntity<>(mpp, HttpStatus.NOT_FOUND);
    }



    // everything else
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,Object>> handleAll(Exception e){

        Map<String,Object> mpp = new HashMap<>();

        mpp.put("timestamp", LocalDateTime.now());
        mpp.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        mpp.put("message", e.getMessage());


        return new ResponseEntity<>(
                mpp,
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}