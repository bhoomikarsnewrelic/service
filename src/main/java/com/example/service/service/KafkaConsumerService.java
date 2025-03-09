package com.example.service.service;

import com.example.service.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Service
public class KafkaConsumerService {

    private final Sinks.Many<Product> sink = Sinks.many().multicast().onBackpressureBuffer();
    private final Flux<Product> flux = sink.asFlux().cache(0);
    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(
            autoStartup = "${kafka.auto.start:true}",
            topics = "${kafka.topic}",
            groupId = "${kafka.groupId}",
            containerFactory = "concurrentKafkaListenerContainerFactory"
    )
    public void listen(String message) {
        try {
            Product product = parseMessage(message);
            sink.tryEmitNext(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Product parseMessage(String message) throws Exception {
        return objectMapper.readValue(message, Product.class);
    }

    public Publisher<Product> getPublisher() {
        return this.flux;
    }
}
