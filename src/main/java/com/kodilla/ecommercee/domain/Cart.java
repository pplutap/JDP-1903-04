package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Cart {

    private Long cartId;
    private String cartName;
    private Long userId;
    private List<Product> products = new ArrayList<>();

    public Cart(Long cartId, String cartName, Long userId) {
        this.cartId = cartId;
        this.cartName = cartName;
        this.userId = userId;
    }

}
