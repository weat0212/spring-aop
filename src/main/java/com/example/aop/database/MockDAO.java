package com.example.aop.database;


import java.util.Optional;

public class MockDAO {

    public Optional<ProductEntity> findMockEntity(int id) {
        return Optional.of(ProductEntity.builder().id(id).price(100).quantity(1).name(String.valueOf(id)).build());
    }
}
