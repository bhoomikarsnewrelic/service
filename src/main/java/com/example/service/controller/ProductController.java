package com.example.service.controller;

import com.example.service.model.Product;
import com.example.service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;


    @QueryMapping
    public String health() {
        System.out.println("health api");
        return "Server is up and running!";
    }

    @QueryMapping
    public Product getProductByID(@Argument String id) {
        System.out.println("getProductByID api id: " + id);
        return productService.getProduct(id);
    }

    @QueryMapping
    public List<Product> getAllProducts() {
        System.out.println("getAllProducts api");
        return productService.getAllProducts();
    }

    @MutationMapping
    public Product createProduct(@Argument String name, @Argument Double price, @Argument Integer quantity) {
        return productService.addProduct(name, price, quantity);
    }


    @MutationMapping
    public Product updateProduct(@Argument String id, @Argument Integer quantity) {
        return productService.updateProduct(id, quantity);
    }

    @MutationMapping
    public Boolean deleteProduct(@Argument String id) {
        return productService.deleteProduct(id);
    }
}