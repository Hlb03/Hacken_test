package com.example.hackentest.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class UserDto {
    @CsvBindByName(column = "first name")
    private String firstName;
    @CsvBindByName(column = "last name")
    private String lastName;
    @CsvBindByName(column = "email")
    private String email;
    @CsvBindByName(column = "country")
    private String country;
    @CsvBindByName(column = "about user")
    private String userAbout;
}
