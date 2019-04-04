package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartMapper {

    @Autowired
    ProductMapper productMapper;

    public Cart mapToCart(final CartDto cartDto) {
        return new Cart(cartDto.getCartId(), cartDto.getCartName(), cartDto.getUserId(), productMapper.mapToProductList(cartDto.getProducts()));
    }

    public CartDto mapToCartDto(final Cart cart) {
        return new CartDto(cart.getCartId(),
                cart.getCartName(),cart.getUserId(),
               productMapper.mapToProductDtoList(cart.getProducts()));
    }

    public List<CartDto> mapToCartDtoList(final List<Cart> carts) {
        return carts.stream()
                .map(cart -> new CartDto(cart.getCartId(),cart.getCartName(),cart.getUserId(),productMapper.mapToProductDtoList(cart.getProducts())))
                .collect(Collectors.toList());
    }

    public List<Cart> mapToCartList(final List<CartDto> cartDtoList) {
        return cartDtoList.stream()
                .map(cartDto -> new Cart(cartDto.getCartId(), cartDto.getCartName(), cartDto.getUserId(),productMapper.mapToProductList(cartDto.getProducts())))
                .collect(Collectors.toList());
    }
}
