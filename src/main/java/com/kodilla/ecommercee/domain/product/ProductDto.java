package com.kodilla.ecommercee.domain.product;

import com.kodilla.ecommercee.domain.cart.Cart;
import com.kodilla.ecommercee.domain.group.Group;
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
public class ProductDto {
    private Long productId;
    private String name;
    private String description;
    private Double price;
    private Group group;
    private Boolean deleted;
    private List<Cart> carts = new ArrayList<>();
}