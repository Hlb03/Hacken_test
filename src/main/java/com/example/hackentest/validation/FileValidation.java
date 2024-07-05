package com.example.hackentest.validation;

import com.example.hackentest.exceptions.EmptyFileException;
import com.example.hackentest.exceptions.FileTypeIsNotSupported;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileValidation {

    public void validateFile(MultipartFile csvFile) {
        String[] splittedFileName = csvFile.getOriginalFilename().split("\\.");

        if (!splittedFileName[splittedFileName.length - 1].equals("csv"))
            throw new FileTypeIsNotSupported("Only files with .csv extension are supported");

        if (csvFile.isEmpty())
            throw new EmptyFileException("File should not be empty");
    }
}
