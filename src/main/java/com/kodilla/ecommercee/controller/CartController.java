package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductMapper productMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getProductsFromCart")
    public List<ProductDto> getProductsFromCart() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.POST, value = "createCart")
    public void createCart(@RequestBody CartDto cartDto) {
        Cart newCart = cartMapper.mapToCart(cartDto);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createOrder")
    public void createOrder(@RequestBody CartDto cartDto) {
        Order newOrder = new Order(cartMapper.mapToCart(cartDto));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addItemToCart")
    public void addItemToCart(@RequestBody ProductDto productDto) {
        Cart newCart = new Cart();
        newCart.getProducts().add(productMapper.mapToProduct(productDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteItemFromCart")
    public void deleteItemFromCart(@RequestParam Long itemId) {
        Cart newCart = new Cart("testCart");
        Product laptop = new Product(1L,"Notebook","15 inch");
        newCart.getProducts().remove(laptop); //W prawdziwej implementacji ustawienie pola boolean "isDeleted" produktu na true
    }
}
