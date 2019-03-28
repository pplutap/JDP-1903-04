package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Product {

    private Long productId;
    private String productName;

    public Product(String productName) {
        this.productName = productName;
    }
}
