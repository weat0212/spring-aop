package com.example.aop.database;


import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MockDAO implements IMockDAO {

    public Optional<ProductEntity> findMockEntity(int id) {
        return Optional.of(ProductEntity.builder().id(id).price(100).quantity(1).name(String.valueOf(id)).build());
    }
}
