package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.carts.Cart;
import com.kodilla.ecommercee.domain.carts.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartMapper {
    private ProductMapper productMapper;

    @Autowired
    public CartMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public Cart mapToCart(final CartDto cartDto) {
        return new Cart(cartDto.getCartId(), cartDto.getItems());
    }

    public CartDto mapToCartDto(final Cart cart) {
        return new CartDto(cart.getCartId(), cart.getItems());
    }
}