package com.example.hackentest.repository;

import com.example.hackentest.entity.UserEntity;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends ElasticsearchRepository<UserEntity, Long> {
    @Query("{\"match\": {\"?0\": \"?1\"}}")
    List<UserEntity> findByFieldAndKeyWord(String field, String value);
    @Query("{\"multi_match\": {\"query\": \"?0\"}}")
    List<UserEntity> findByKeyWord(String keyWord);
}
