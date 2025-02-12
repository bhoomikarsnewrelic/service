package com.example.service.service;

import com.example.service.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    private final Map<String, Product> productMap = new HashMap<>();

    @Autowired
    private ProductSubscriptionService productSubscriptionService;


    public Product addProduct(String name, Double price, Integer quantity) {
        Product product = new Product(UUID.randomUUID().toString(), name, price, quantity);
        productMap.put(product.getId(), product);
        productSubscriptionService.emitEvent(product);
        return product;
    }


    public Product getProduct(String id) {
        return productMap.getOrDefault(id, null);
    }

    public List<Product> getAllProducts() {
        return List.copyOf(productMap.values());
    }

    public Product updateProduct(String id, Integer quantity) {

        if (productMap.containsKey(id)) {
            Product product = productMap.get(id);
            product.setQuantity(quantity);
            return product;
        } else {
            throw new IllegalArgumentException("Product not found");
        }
    }

    public Boolean deleteProduct(String id) {
        return Optional.ofNullable(productMap.remove(id)).isPresent();
    }
}
