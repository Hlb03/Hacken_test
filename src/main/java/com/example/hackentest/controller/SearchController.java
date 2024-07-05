package com.example.hackentest.controller;

import com.example.hackentest.dto.DataContainer;
import com.example.hackentest.dto.SearchDto;
import com.example.hackentest.entity.UserEntity;
import com.example.hackentest.service.SearchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/{keyWord}")
    public DataContainer<List<UserEntity>> fullTextSearchByKeyWork(@PathVariable String keyWord) {
        return searchService.fullTextSearchByKeyWord(keyWord);
    }

    @PostMapping
    public DataContainer<List<UserEntity>> searchByKeyAndValue(@RequestBody @Valid SearchDto search) {
        return searchService.searchByKeyAndValue(search);
    }
}
