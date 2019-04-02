package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.domain.orders.Order;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.smartcardio.Card;
import java.util.List;
import java.util.ArrayList;
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
        Product jam = new Product(1L,"Jam","Strawberry jam");
        Cart cart1 = new Cart(cartId, "DefaultUserCart");
        cart1.getProducts().add(jam);
        return cart1.getProducts().stream()
                .map(product -> new ProductDto(product.getProductId(), product.getName(), product.getDescription()))
                .collect(Collectors.toList());
    }

    @PostMapping(value = "createCart", consumes = APPLICATION_JSON_VALUE)
    public void createCart(@RequestBody CartDto cartDto) {
        Cart newCart = cartMapper.mapToCart(cartDto);
    }

    @PostMapping(value = "createOrder", consumes = APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody CartDto cartDto) {
        Order newOrder = new Order(cartMapper.mapToCart(cartDto));
    }

    @PostMapping(value = "addItemToCart", consumes = APPLICATION_JSON_VALUE)
    public void addItemToCart(@RequestBody ProductDto productDto, @RequestParam Long cartId) {
        Cart newCart = new Cart(cartId, "UserCart");
        newCart.getProducts().add(productMapper.mapToProduct(productDto));
    }

    @DeleteMapping(value = "deleteProductFromCart")
    public void deleteProductFromCart(@RequestParam Long productId, Long cartId) {
        Cart newCart = new Cart(cartId,"testCart");
        Product laptop = new Product(productId,"Notebook","15 inch");
        newCart.getProducts().add(laptop);
        newCart.getProducts().remove(laptop); //W prawdziwej implementacji ustawienie pola boolean "isDeleted" produktu na true
    }
}
