package com.kodilla.ecommercee.domain.carts;

import com.kodilla.ecommercee.domain.order.ItemDto;
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
    private List<ItemDto> items = new ArrayList<>();

    public CartDto(Long cartId, String cartName, Long userId, List<ItemDto> items) {
        this.cartId = cartId;
        this.cartName = cartName;
        this.userId = userId;
        this.items = items;
    }
}
