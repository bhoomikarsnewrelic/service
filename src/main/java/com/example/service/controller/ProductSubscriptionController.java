package com.example.service.controller;

import com.example.service.model.Product;
import com.example.service.service.ProductSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
public class ProductSubscriptionController {

    @Autowired
    private ProductSubscriptionService productSubscriptionService;


    @SubscriptionMapping
    public Flux<Product> productAdded() {
        System.out.println("subscription endPoint");
        return productSubscriptionService.subscribe();
    }
}
