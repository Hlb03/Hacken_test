package com.example.hackentest.controller;

import com.example.hackentest.dto.DataContainer;
import com.example.hackentest.dto.SearchDto;
import com.example.hackentest.entity.UserEntity;
import com.example.hackentest.service.SearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @Operation(
            summary = "Search data by the certain key word",
            description = "Endpoint that implements full-text search by the provided key word"
    )
    @GetMapping("/{keyWord}")
    public DataContainer<List<UserEntity>> fullTextSearchByKeyWork(
            @Parameter(description = "Value, which will be search through the whole index")
            @PathVariable String keyWord) {
        return searchService.fullTextSearchByKeyWord(keyWord);
    }

    @Operation(
            summary = "Search data by field and certain value",
            description = "Endpoint to search data by the certain field and value, which are provided in request body",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "'key' field represents field on which search will performed; 'value' field represents actual value which will be searched",
                    required = true)
    )
    @PostMapping
    public DataContainer<List<UserEntity>> searchByKeyAndValue(@RequestBody @Valid SearchDto search) {
        return searchService.searchByKeyAndValue(search);
    }
}
