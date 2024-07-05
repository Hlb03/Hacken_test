package com.example.hackentest.service;

import com.example.hackentest.dto.DataContainer;
import com.example.hackentest.dto.SearchDto;
import com.example.hackentest.entity.UserEntity;

import java.util.List;

public interface SearchService {
    DataContainer<List<UserEntity>> fullTextSearchByKeyWord(String keyWord);
    DataContainer<List<UserEntity>> searchByKeyAndValue(SearchDto searchDto);
}
