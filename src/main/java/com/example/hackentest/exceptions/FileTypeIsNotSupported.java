package com.example.hackentest.exceptions;

public class FileTypeIsNotSupported extends BadRequestException {
    public FileTypeIsNotSupported(String message) {
        super(message);
    }
}
