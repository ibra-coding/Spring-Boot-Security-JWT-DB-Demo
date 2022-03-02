package com.example.springbootsecuritydbdemo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
public class ApiDomen {
    private final String message;
    private final ZonedDateTime timestamp;
}
