package com.example.service.service;

import com.example.service.model.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Service
public class ProductSubscriptionService {

    private final Sinks.Many<Product> sink = Sinks.many().multicast().onBackpressureBuffer();
    private final Flux<Product> flux = sink.asFlux().cache(0);

    public void emitEvent(Product event) {
        this.sink.tryEmitNext(event);
    }

    public Flux<Product> subscribe() {
        return this.flux;
    }

}
