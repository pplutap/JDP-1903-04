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
        return new Cart(cartDto.getCartId(), productMapper.mapToProductList(cartDto.getProducts()));
    }

    public CartDto mapToCartDto(final Cart cart) {
        return new CartDto(cart.getCartId(), productMapper.mapToProductDtoList(cart.getProducts()));
    }

    public List<CartDto> mapToCartDtoList(final List<Cart> carts) {
        return carts.stream()
                .map(cart -> new CartDto(cart.getCartId(),productMapper.mapToProductDtoList(cart.getProducts())))
                .collect(Collectors.toList());
    }

    public List<Cart> mapToCartList(final List<CartDto> cartDtoList) {
        return cartDtoList.stream()
                .map(cartDto -> new Cart(cartDto.getCartId(), productMapper.mapToProductList(cartDto.getProducts())))
                .collect(Collectors.toList());
    }
}
