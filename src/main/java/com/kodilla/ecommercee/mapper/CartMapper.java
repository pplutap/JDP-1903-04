package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartDto;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {

    public Cart mapToCart(final CartDto cartDto) {
        return new Cart(cartDto.getCartName());
    }

    public CartDto mapToCartDto(final Cart cart) {
        return new CartDto(cart.getCartId(),
                cart.getCartName(),
                cart.getProducts());
    }
}
