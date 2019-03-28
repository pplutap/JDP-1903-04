package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CartDto {

    private Long cartId;
    private String cartName;
    private List<Product> products = new ArrayList<>();

    public CartDto(String cartName) {
        this.cartName = cartName;
    }

}
