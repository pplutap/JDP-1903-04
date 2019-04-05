package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.carts.Cart;
import com.kodilla.ecommercee.domain.carts.CartDto;
import com.kodilla.ecommercee.domain.orders.Order;
import com.kodilla.ecommercee.domain.products.Product;
import com.kodilla.ecommercee.domain.products.ProductDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;
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
    private ProductService productService;

    @GetMapping(value = "getProductsFromCart")
    public List<ProductDto> getProductsFromCart(@RequestParam Long cartId)  {
        Product jam = new Product("Jam", "Strawberry jam", new BigDecimal(5), false);
        Cart cart1 = new Cart(cartId, "DefaultUserCart", productService.getAllProducts());
        cart1.getProducts().add(jam);
        return cart1.getProducts().stream()
                .map(product -> new ProductDto(product.getProductId(), product.getName(), product.getDescription(),
                        product.getPrice(), product.isDeleted()))
                .collect(Collectors.toList());
    }

    @PostMapping(value = "createCart", consumes = APPLICATION_JSON_VALUE)
    public void createCart(@RequestBody CartDto cartDto) {
        Cart newCart = cartMapper.mapToCart(cartDto);
    }

    @PostMapping(value = "createOrder", consumes = APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody CartDto cartDto) {
        Order newOrder = new Order(cartDto.getCartId(), cartMapper.mapToCart(cartDto));
    }

    @PostMapping(value = "addItemToCart", consumes = APPLICATION_JSON_VALUE)
    public void addItemToCart(@RequestBody ProductDto productDto, CartDto cartDto) {
        Cart newCart = new Cart(cartDto.getCartId(), "UserCart", productService.getAllProducts());
        newCart.getProducts().add(productMapper.mapToProduct(productDto));
    }

    @DeleteMapping(value = "deleteProductFromCart")
    public void deleteProductFromCart(@RequestParam Long productId, Long cartId) {
        Cart newCart = new Cart(cartId,"testCart", productService.getAllProducts());
        Product laptop = new Product("Notebook", "Notebook_desc", new BigDecimal(500), false);
        newCart.getProducts().add(laptop);
        newCart.getProducts().remove(laptop); //W prawdziwej implementacji ustawienie pola boolean "isDeleted" produktu na true
    }
}
