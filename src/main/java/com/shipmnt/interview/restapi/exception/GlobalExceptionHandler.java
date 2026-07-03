package com.shipmnt.interview.restapi.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class GlobalExceptionHandler {


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