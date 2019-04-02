package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
    private Long orderId;
    private Long userId;
    private List<Product> products = new ArrayList<>();
    private boolean isPaid = false;
    private boolean isVerified = false;
    private boolean isSubmited = false;

    public Order(Long userId, Cart cart) {
        this.userId = userId;
        this.products = cart.getProducts();
    }
}
