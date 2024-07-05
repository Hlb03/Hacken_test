package com.example.hackentest.service.implementation;

import com.example.hackentest.dto.DataContainer;
import com.example.hackentest.dto.SearchDto;
import com.example.hackentest.entity.UserEntity;
import com.example.hackentest.repository.UserRepository;
import com.example.hackentest.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {

    private final UserRepository userRepository;

    @Override
    public DataContainer<List<UserEntity>> fullTextSearchByKeyWord(String keyWord) {
        log.info("Full text search by the key word -> {}", keyWord);
        return new DataContainer<>(userRepository.findByKeyWord(keyWord));
    }

    @Override
    public DataContainer<List<UserEntity>> searchByKeyAndValue(SearchDto searchDto) {
        log.info("Searching users by key {} and value {}", searchDto.key(), searchDto.value());
        return new DataContainer<>(userRepository.findByFieldAndKeyWord(searchDto.key().name(), searchDto.value()));
    }
}
