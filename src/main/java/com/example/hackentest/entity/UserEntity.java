package com.example.hackentest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;
import java.util.Objects;

@Data
@Builder
@EqualsAndHashCode(of = "id")
@Document(indexName = "user")
@AllArgsConstructor
public class UserEntity {

    @Id
    @Field(type = FieldType.Keyword)
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String country;
    private String aboutUser;

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", aboutUser='" + aboutUser + '\'' +
                '}';
    }
}
