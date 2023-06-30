package com.example.aop.database;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductEntity {

    private int id;

    private String name;

    private double price;

    private int quantity;
}
