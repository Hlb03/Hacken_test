package com.example.hackentest.controller;

import com.example.hackentest.service.ParserService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class FileController {

    private final ParserService parserService;

    @PostMapping(consumes = "multipart/form-data")
    @ResponseStatus(HttpStatus.OK)
    public void uploadFile(
            @Parameter(description = "File to be uploaded")
            @RequestParam("csvFile") MultipartFile csvFile) {
        parserService.parseCsvFile(csvFile);
    }
}