package com.kodilla.ecommercee.domain.products;

import com.kodilla.ecommercee.domain.carts.Cart;
import com.kodilla.ecommercee.domain.groups.Group;
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
    private Long id;
    private String name;
    private String description;
    private List<Cart> carts = new ArrayList<>();
    private Group group;
}
