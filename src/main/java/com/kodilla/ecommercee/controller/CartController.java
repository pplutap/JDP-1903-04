package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.cart.Cart;
import com.kodilla.ecommercee.domain.cart.CartDto;
import com.kodilla.ecommercee.domain.group.Group;
import com.kodilla.ecommercee.domain.order.Order;
import com.kodilla.ecommercee.domain.product.Product;
import com.kodilla.ecommercee.domain.product.ProductDto;
import com.kodilla.ecommercee.domain.user.User;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductMapper productMapper;

    @GetMapping(value = "getProductsFromCart")
    public List<ProductDto> getProductsFromCart(@RequestParam Long cartId)  {
        Product jam = new Product(1L, "Test name", "Test desc", 34.3, new Group(), false, new ArrayList<>());
        Cart cart1 = new Cart(cartId, new ArrayList<>());
        cart1.getProducts().add(jam);
        return cart1.getProducts().stream()
                .map(product -> productMapper.mapToProductDto(product))
                .collect(Collectors.toList());
    }

    @PostMapping(value = "createCart", consumes = APPLICATION_JSON_VALUE)
    public void createCart(@RequestBody CartDto cartDto) {
        Cart newCart = cartMapper.mapToCart(cartDto);
    }

    @PostMapping(value = "createOrder", consumes = APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody CartDto cartDto) {
        Order newOrder = cartMapper.mapToOrder(cartDto);
    }

    @PostMapping(value = "addItemToCart", consumes = APPLICATION_JSON_VALUE)
    public void addItemToCart(@RequestBody ProductDto productDto, @RequestParam Long cartId) {
        Cart newCart = new Cart(cartId, new ArrayList<>());
        newCart.getProducts().add(productMapper.mapToProduct(productDto));
    }

    @DeleteMapping(value = "deleteProductFromCart")
    public void deleteProductFromCart(@RequestParam Long productId, Long cartId) {
        Cart newCart = new Cart(cartId,new ArrayList<>());
        Product jam = new Product(1L, "Test name", "Test desc", 34.3, new Group(), false, new ArrayList<>());
        newCart.getProducts().add(jam);
        newCart.getProducts().remove(jam); //W prawdziwej implementacji ustawienie pola boolean "isDeleted" produktu na true
    }
}
