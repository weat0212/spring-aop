package com.example.aop.service;

import com.example.aop.annotation.InventoryOperation;
import com.example.aop.exception.OperationException;
import com.example.aop.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ShoppingService {

    @InventoryOperation(operation = "launch")
    public void launch(Product product, double price, int quantity) {
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setVisible(true);
    }

    @InventoryOperation(operation = "offShelve")
    public void offShelve(Product product) throws OperationException {
        if (product.getQuantity() == 0 || !product.isVisible()) throw new OperationException("No product leave...");
        product.setQuantity(0);
        product.setVisible(false);
    }
}
