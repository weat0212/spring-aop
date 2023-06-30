package com.example.aop.service;

import com.example.aop.annotation.InventoryOperation;
import com.example.aop.database.IMockDAO;
import com.example.aop.exception.OperationException;
import com.example.aop.model.Product;
import com.example.aop.model.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ShoppingService {

    private final IMockDAO mockDAO;

    private final ProductMapper productMapper;

    public ShoppingService(@Qualifier("mockDAOProxy") IMockDAO mockDAO, ProductMapper productMapper) {
        this.mockDAO = mockDAO;
        this.productMapper = productMapper;
    }

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

    public Product getProduct() {
        return mockDAO.findMockEntity(1).map(productMapper::toDto).orElseThrow();
    }
}
