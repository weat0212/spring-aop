package com.example.aop.controller;

import com.example.aop.exception.OperationException;
import com.example.aop.model.Product;
import com.example.aop.service.ShoppingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop")
public class ShoppingController {

    public static final Product MOCK_PRODUCT = Product.builder().name("Red Bull rb19").price(3000).visible(true).quantity(1).build();

    private final ShoppingService shoppingService;

    public ShoppingController(ShoppingService shoppingService) {
        this.shoppingService = shoppingService;
    }

    @GetMapping("/launch")
    public void newProduct() {
        shoppingService.launch(Product.builder().name("Aston Martin amr23").build(), 3000, 1);
    }

    @GetMapping("/offShelve")
    public void offShelve() throws OperationException {
        shoppingService.offShelve(MOCK_PRODUCT);
    }
}
