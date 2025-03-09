package com.example.service.controller;

import com.example.service.model.Product;
import com.example.service.service.KafkaConsumerService;
import com.example.service.service.ProductSubscriptionService;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ProductSubscriptionController {

    @Autowired
    private ProductSubscriptionService productSubscriptionService;

    @Autowired
    private KafkaConsumerService kafkaConsumerService;


    @SubscriptionMapping
    public Publisher<Product> productAdded() {
        System.out.println("subscription endPoint");
        return kafkaConsumerService.getPublisher();
    }
}
