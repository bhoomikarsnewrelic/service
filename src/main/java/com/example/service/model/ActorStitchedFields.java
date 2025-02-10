package com.example.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorStitchedFields {
    private String health;
    private List<Product> products;
    private Product product;
}
