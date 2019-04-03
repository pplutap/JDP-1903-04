package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.cart.Cart;
import com.kodilla.ecommercee.domain.cart.CartDto;
import com.kodilla.ecommercee.domain.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartMapper {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    ItemMapper itemMapper;

    public Cart mapToCart(final CartDto cartDto) {
        return new Cart(cartDto.getCartId(), productMapper.mapToProductList(cartDto.getProducts()));
    }

    public CartDto mapToCartDto(final Cart cart) {
        return new CartDto(cart.getCartId(),productMapper.mapToProductDtoList(cart.getProducts()));
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

    public Order mapToOrder(CartDto cartDto) {
        Order order = new Order();
        order.setOrderId(1L);
        order.setDate(new Date());
        order.setItems(itemMapper.productDtoListToItemList(cartDto.getProducts()));
        order.setPaid(false);
        return order;
    }
}
