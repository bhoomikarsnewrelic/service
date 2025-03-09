package com.example.service.service;

import com.example.service.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;


    public void sendMessage(Product product) {
        try {
            String message = objectMapper.writeValueAsString(product);
            System.out.printf("Producing message: %s%n", message);
            kafkaTemplate.send("productAddedTopic", message); // Sending serialized Product as a JSON string
        } catch (JsonProcessingException e) {
            System.err.printf("Failed to serialize product: %s%n", e.getMessage());
        }
    }
}
