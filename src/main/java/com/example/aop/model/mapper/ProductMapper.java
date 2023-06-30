package com.example.aop.model.mapper;

import com.example.aop.database.ProductEntity;
import com.example.aop.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toDto(ProductEntity entity) {
        return Product.builder().name(entity.getName()).price(entity.getPrice()).quantity(entity.getQuantity()).build();
    }
}
