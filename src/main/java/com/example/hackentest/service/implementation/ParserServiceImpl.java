package com.example.hackentest.service.implementation;

import com.example.hackentest.dto.UserDto;
import com.example.hackentest.entity.UserEntity;
import com.example.hackentest.exceptions.ParseDataException;
import com.example.hackentest.repository.UserRepository;
import com.example.hackentest.service.ParserService;
import com.example.hackentest.validation.FileValidation;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ParserServiceImpl implements ParserService {

    private final UserRepository userRepository;
    private final FileValidation fileValidation;

    @Override
    public void parseCsvFile(MultipartFile csvFile) {
        fileValidation.validateFile(csvFile);

        List<UserDto> usersFromFile = parseDataFromCsvFile(csvFile);

        userRepository.saveAll(
                usersFromFile.stream()
                        .map(this::mapDtoToEntity)
                        .toList()
        );
        log.info("Saved data form csv file with name {}", csvFile.getOriginalFilename());
    }

    private List<UserDto> parseDataFromCsvFile(MultipartFile csvFile) {
        List<UserDto> usersFromCsv;
        try (Reader reader = new BufferedReader(new InputStreamReader(csvFile.getInputStream()))) {
            usersFromCsv = new CsvToBeanBuilder<UserDto>(reader)
                    .withType(UserDto.class)
                    .build()
                    .parse();
            log.info("Parsing data from csv file. Total amount of records is: {}", usersFromCsv.size());
        } catch (IOException e) {
            throw new ParseDataException("Failed to parse data from file. Try again later");
        }

        return usersFromCsv;
    }

    private UserEntity mapDtoToEntity(UserDto dto) {
        return UserEntity
                .builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .country(dto.getCountry())
                .aboutUser(dto.getUserAbout())
                .build();
    }
}
