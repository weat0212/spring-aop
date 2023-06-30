package com.example.aop.database;

import java.util.Optional;

public interface IMockDAO {
    Optional<ProductEntity> findMockEntity(int i);
}
