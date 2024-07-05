package com.example.hackentest.exceptions.handler;

public record ExceptionContainer<T>(
        T errors
) {}
