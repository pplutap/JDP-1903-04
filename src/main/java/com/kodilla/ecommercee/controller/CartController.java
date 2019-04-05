package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.carts.Cart;
import com.kodilla.ecommercee.domain.carts.CartDto;
import com.kodilla.ecommercee.domain.groups.Group;
import com.kodilla.ecommercee.domain.orders.Order;
import com.kodilla.ecommercee.domain.products.Product;
import com.kodilla.ecommercee.domain.products.ProductDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
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
    @Autowired
    private GroupMapper groupMapper;

    @GetMapping(value = "getProductsFromCart")
    public List<ProductDto> getProductsFromCart(@RequestParam Long cartId)  {
        Group food = new Group();
        Product jam = new Product("Jam","Strawberry jam",food);
        List<Product> list = Arrays.asList(jam);
        Cart cart1 = new Cart("DefaultUserCart", 15L,list);
        cart1.getProducts().add(jam);
        return cart1.getProducts().stream()
                .map(product -> new ProductDto(product.getProductId(), product.getName(),
                        product.getDescription(),groupMapper.mapToGroupDto(product.getGroup())))
                .collect(Collectors.toList());
    }

    @PostMapping(value = "createCart", consumes = APPLICATION_JSON_VALUE)
    public void createCart(@RequestBody CartDto cartDto) {
        Cart newCart = cartMapper.mapToCart(cartDto);
    }

    @PostMapping(value = "createOrder", consumes = APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody CartDto cartDto) {
        Order newOrder = new Order(cartDto.getUserId(), cartMapper.mapToCart(cartDto));
    }

    @PostMapping(value = "addItemToCart", consumes = APPLICATION_JSON_VALUE)
    public void addItemToCart(@RequestBody ProductDto productDto, CartDto cartDto) {
        Group food = new Group();
        Product jam = new Product("Jam","Strawberry jam",food);
        List<Product> list = Arrays.asList(jam);
        Cart newCart = new Cart("UserCart", cartDto.getUserId(),list);
        newCart.getProducts().add(productMapper.mapToProduct(productDto));
    }

    @DeleteMapping(value = "deleteProductFromCart")
    public void deleteProductFromCart(@RequestParam Long productId, Long cartId) {
        Group food = new Group();
        Product jam = new Product("Jam","Strawberry jam",food);
        List<Product> list = Arrays.asList(jam);
        Cart newCart = new Cart("testCart", 15L,list);
        Product laptop = new Product("Notebook","15 inch",food);
        newCart.getProducts().add(laptop);
        newCart.getProducts().remove(laptop); //W prawdziwej implementacji ustawienie pola boolean "isDeleted" produktu na true
    }
}
