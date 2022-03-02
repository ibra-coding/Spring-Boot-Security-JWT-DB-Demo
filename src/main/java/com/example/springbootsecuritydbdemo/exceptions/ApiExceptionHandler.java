package com.example.springbootsecuritydbdemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> notFound(NotFoundException notFoundException) {
        ApiDomen apiDomen = new ApiDomen(notFoundException.getMessage(), ZonedDateTime.now());
        return new ResponseEntity<>(apiDomen, HttpStatus.NOT_FOUND);
    }
}
