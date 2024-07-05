package com.example.hackentest.exceptions;

public class EmptyFileException extends BadRequestException {
    public EmptyFileException(String message) {
        super(message);
    }
}
