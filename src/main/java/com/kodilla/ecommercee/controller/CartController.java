package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    private Cart testCart;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductMapper productMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getProductFromCart")
    public ProductDto getProductFromCart(@RequestParam Long productId) {
        return new ProductDto(1L,"Ciastka");
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProductsFromCart")
    public List<ProductDto> getProductsFromCart() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.POST, value = "createCart")
    public void createCart(@RequestBody CartDto cartDto) {
        this.testCart = cartMapper.mapToCart(cartDto);
    }

    @RequestMapping(method = RequestMethod.POST, value = "addItemToCart")
    public void addItemToCart(@RequestBody ProductDto productDto) {
        this.testCart.getProducts().add(productMapper.mapToProduct(productDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteItemFromCart")
    public void deleteItemFromCart(@RequestParam Long itemId) {
        this.testCart.getProducts().remove(new Product()); //W prawdziwej implementacji ustawienie pola boolean "isDeleted" produktu na true
    }
}
