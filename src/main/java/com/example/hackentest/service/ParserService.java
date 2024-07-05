package com.example.hackentest.service;

import org.springframework.web.multipart.MultipartFile;

public interface ParserService {

    void parseCsvFile(MultipartFile csvFile);
}
