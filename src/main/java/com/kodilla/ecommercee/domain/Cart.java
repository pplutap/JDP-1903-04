package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.ArrayList;

@NoArgsConstructor
@Getter
public class Cart {

    private Long cartId;
    private String cartName;
    private List<Product> products = new ArrayList<>();

    public Cart(String cartName) {
        this.cartName = cartName;
    }
}
