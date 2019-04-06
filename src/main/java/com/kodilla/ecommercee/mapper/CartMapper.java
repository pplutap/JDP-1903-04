package com.kodilla.ecommercee.mapper;
import com.kodilla.ecommercee.assembler.ItemAssembler;
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

    @Autowired
    ItemAssembler itemAssembler;

    public Cart cartDtoToCart(final CartDto cartDto) {
        return new Cart(cartDto.getId(), cartDto.getUserId(), productMapper.productDtoListToProductList(cartDto.getProduct()));
    }

    public CartDto cartToCartDto(final Cart cart) {
        return new CartDto(cart.getId(), cart.getUserId(),productMapper.productListToProductDtoList(cart.getProducts()));
    }

    public List<CartDto> cartListToCartDtoList(final List<Cart> carts) {
        return carts.stream()
                .map(cart -> new CartDto(cart.getId(),cart.getUserId(),productMapper.productListToProductDtoList(cart.getProducts())))
.collect(Collectors.toList());
    }

    public List<Cart> cartDtoListToCartList(final List<CartDto> cartDtoList) {
        return cartDtoList.stream()
                .map(cartDto -> new Cart(cartDto.getId(), cartDto.getUserId(), productMapper.productDtoListToProductList(cartDto.getProduct()))).collect(Collectors.toList());
    }

    public Order mapToOrder(CartDto cartDto) {
        Order order = new Order();
        order.setId(1L);
        order.setDate(new Date());
        order.setItems(itemAssembler.productDtoListToItemList(cartDto.getProduct()));
        order.setPaid(false);
        return order;
    }
}
