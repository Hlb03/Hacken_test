package com.example.hackentest.exceptions.handler;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

public record ExceptionResponse(
        int status,
        HttpStatus error,
        LocalDateTime timestamp,
        List<String> errorMessages,
        String path
) {}
