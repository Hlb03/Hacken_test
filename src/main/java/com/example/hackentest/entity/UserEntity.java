package com.example.hackentest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;
import java.util.Objects;

@Data
@Builder
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
    @Field(type = FieldType.Date)
    private LocalDate creationDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

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
