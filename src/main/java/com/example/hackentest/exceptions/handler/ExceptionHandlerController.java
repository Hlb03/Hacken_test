package com.example.hackentest.exceptions.handler;

import com.example.hackentest.exceptions.BadRequestException;
import com.example.hackentest.exceptions.ParseDataException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ExceptionContainer<ExceptionResponse> catchBadRequestException(BadRequestException e, HttpServletRequest request) {
        return buildResponse(400, HttpStatus.BAD_REQUEST, List.of(e.getMessage()), request.getRequestURI());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ExceptionContainer<ExceptionResponse> catchConstrainViolations(ConstraintViolationException e, HttpServletRequest request) {
        return buildResponse(400, HttpStatus.BAD_REQUEST, List.of(e.getMessage()), request.getRequestURI());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ExceptionContainer<ExceptionResponse> catchNotValidMethodArguments(MethodArgumentNotValidException e, HttpServletRequest request) {
        return buildResponse(400, HttpStatus.BAD_REQUEST,
                e.getAllErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage).toList(), request.getRequestURI());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ParseDataException.class)
    public ExceptionContainer<ExceptionResponse> catchParseException(ParseDataException e, HttpServletRequest request) {
        return buildResponse(500, HttpStatus.INTERNAL_SERVER_ERROR, List.of(e.getMessage()), request.getRequestURI());
    }

    private ExceptionContainer<ExceptionResponse> buildResponse(int status, HttpStatus error, List<String> errorMessages, String path) {
        return new ExceptionContainer<>(new ExceptionResponse(status, error, LocalDateTime.now(), errorMessages, path));
    }
}
