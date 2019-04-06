package com.kodilla.ecommercee.domain.carts;

import com.kodilla.ecommercee.domain.products.ProductDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class CartDto {

    private Long cartId;
    private Long userId;
    private List<ProductDto> products = new ArrayList<>();

    public CartDto(Long cartId, Long userId, List<ProductDto> products) {
        this.cartId = cartId;
        this.userId = userId;
        this.products = products;
    }
}
