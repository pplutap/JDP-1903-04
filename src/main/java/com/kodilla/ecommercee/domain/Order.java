package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Order {

    private Long orderId;
    private Long userId;
    private Cart cart;

    public Order(Cart cart) {
        this.cart = cart;
    }
}
