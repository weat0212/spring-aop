package com.example.aop.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

    private String name;

    private int quantity;

    private double price;

    private boolean visible;
}
