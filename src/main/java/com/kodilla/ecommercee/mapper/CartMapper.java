package com.kodilla.ecommercee.mapper;
import com.kodilla.ecommercee.domain.carts.Cart;
import com.kodilla.ecommercee.domain.carts.CartDto;
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
        return new Cart(cartDto.getCartName(), cartDto.getUserId(), productMapper.mapToProductList(cartDto.getItems()));
    }

    public CartDto mapToCartDto(final Cart cart) {
        return new CartDto(cart.getId(),
                cart.getCartName(),cart.getUserId(),
               productMapper.mapToProductDtoList(cart.getProducts()));
    }

    public List<CartDto> mapToCartDtoList(final List<Cart> carts) {
        return carts.stream()
                .map(cart -> new CartDto(cart.getId(),cart.getCartName(),cart.getUserId(),productMapper.mapToProductDtoList(cart.getProducts())))
.collect(Collectors.toList());
    }

    public List<Cart> mapToCartList(final List<CartDto> cartDtoList) {
        return cartDtoList.stream()
                .map(cartDto -> new Cart(cartDto.getCartName(), cartDto.getUserId(),productMapper.mapToProductList(cartDto.getItems()))).collect(Collectors.toList());
    }

    public Order mapToOrder(CartDto cartDto) {
        Order order = new Order();
        order.setId(1L);
        order.setDate(new Date());
        order.setPaid(false);
        return order;
    }
}
