package com.example.hackentest.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record SearchDto(
        @NotNull(message = "'key' field should be present")
        UserEntityField key,
        @NotNull(message = "'value' field should be present")
        @Pattern(regexp = "[a-zA-Z_0-9]+", message = "'value' could contain only capital/lower-case letters, underscores (_) and digits")
        String value
) {}
