package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.carts.Cart;
import com.kodilla.ecommercee.domain.carts.CartDto;
import com.kodilla.ecommercee.domain.products.Product;
import com.kodilla.ecommercee.domain.products.ProductDto;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/cart")
public class CartController {
    private ProductMapper productMapper;
    private ProductService productService;

    @Autowired
    public CartController(ProductMapper productMapper, ProductService productService) {
        this.productMapper = productMapper;
        this.productService = productService;
    }

    @GetMapping(value = "getProductsFromCart")
    public List<ProductDto> getProductsFromCart(@RequestParam Long cartId) {
        Product jam = new Product("Jam", "Strawberry jam", new BigDecimal(5));
        Cart cart1 = new Cart(cartId, productService.getAllProducts());
        cart1.getProducts().add(jam);
        return productMapper.mapToProductDtoList(cart1.getProducts());
    }

    @PostMapping(value = "createCart", consumes = APPLICATION_JSON_VALUE)
    public void createCart(@RequestBody CartDto cartDto) {

    }

    @PostMapping(value = "createOrder", consumes = APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody CartDto cartDto) {

    }

    @PostMapping(value = "addItemToCart", consumes = APPLICATION_JSON_VALUE)
    public void addItemToCart(@RequestBody ProductDto productDto, @RequestParam Long cartId) {

    }

    @DeleteMapping(value = "deleteProductFromCart")
    public void deleteProductFromCart(@RequestParam Long productId, Long cartId) {

    }
}