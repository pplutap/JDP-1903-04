package com.kodilla.ecommercee.domain.carts;

import com.kodilla.ecommercee.domain.orders.Item;
import com.kodilla.ecommercee.domain.products.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CartDto {
    private Long cartId;
    private List<Item> items = new ArrayList<>();
}