package com.kodilla.ecommercee.mapper;
<<<<<<< HEAD
import com.kodilla.ecommercee.domain.carts.Cart;
import com.kodilla.ecommercee.domain.carts.CartDto;
=======

import com.kodilla.ecommercee.domain.cart.Cart;
import com.kodilla.ecommercee.domain.cart.CartDto;
>>>>>>> 1f8caf8cd7ad7c4f02648906c5c592607332b89f
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
<<<<<<< HEAD
        return new Cart(cartDto.getCartName(), cartDto.getUserId(), productMapper.mapToProductList(cartDto.getItems()));
    }

    public CartDto mapToCartDto(final Cart cart) {
        return new CartDto(cart.getId(),
                cart.getCartName(),cart.getUserId(),
               productMapper.mapToProductDtoList(cart.getProducts()));
=======
        return new Cart(cartDto.getId(), productMapper.mapToProductList(cartDto.getProducts()));
    }

    public CartDto mapToCartDto(final Cart cart) {
        return new CartDto(cart.getId(),productMapper.mapToProductDtoList(cart.getProducts()));
>>>>>>> 1f8caf8cd7ad7c4f02648906c5c592607332b89f
    }

    public List<CartDto> mapToCartDtoList(final List<Cart> carts) {
        return carts.stream()
<<<<<<< HEAD
                .map(cart -> new CartDto(cart.getId(),cart.getCartName(),cart.getUserId(),productMapper.mapToProductDtoList(cart.getProducts())))
.collect(Collectors.toList());
=======
                .map(cart -> new CartDto(cart.getId(),productMapper.mapToProductDtoList(cart.getProducts())))
                .collect(Collectors.toList());
>>>>>>> 1f8caf8cd7ad7c4f02648906c5c592607332b89f
    }

    public List<Cart> mapToCartList(final List<CartDto> cartDtoList) {
        return cartDtoList.stream()
<<<<<<< HEAD
                .map(cartDto -> new Cart(cartDto.getCartName(), cartDto.getUserId(),productMapper.mapToProductList(cartDto.getItems()))).collect(Collectors.toList());
    }

    public Order mapToOrder(CartDto cartDto) {
        Order order = new Order();
        order.setId(1L);
        order.setDate(new Date());
        order.setPaid(false);
        return order;
=======
                .map(cartDto -> new Cart(cartDto.getId(), productMapper.mapToProductList(cartDto.getProducts())))
                .collect(Collectors.toList());
>>>>>>> 1f8caf8cd7ad7c4f02648906c5c592607332b89f
    }

    public Order mapToOrder(CartDto cartDto) {
        Order order = new Order();
        order.setId(1L);
        order.setDate(new Date());
        order.setItems(itemMapper.productDtoListToItemList(cartDto.getProducts()));
        order.setPaid(false);
        return order;
    }
}
