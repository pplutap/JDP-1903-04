package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class CartDto {

    private Long cartId;
    private String cartName;
    private Long userId;
    private List<ProductDto> products = new ArrayList<>();

    public CartDto(Long cartId, String cartName, Long userId, List<ProductDto> products) {
        this.cartId = cartId;
        this.cartName = cartName;
        this.userId = userId;
        this.products = products;
    }
}
