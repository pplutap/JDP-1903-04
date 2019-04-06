package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.group.Group;
import com.kodilla.ecommercee.domain.product.Product;
import com.kodilla.ecommercee.domain.product.ProductDto;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/product")
public class ProductController {
    private List<ProductDto> products = new ArrayList<>();

    @GetMapping(value = "getProducts")
    public List<ProductDto> getProducts() {
        return returnListProduct();
    }

    @GetMapping(value = "getProduct")
    public ProductDto getProduct(@RequestParam("id") long productId) {
        returnListProduct();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId().equals(productId)) {
                return products.get(i);
            }
        }
        return null;
    }

    @PostMapping(value = "createProduct", consumes = APPLICATION_JSON_VALUE)
    public void createProduct(@RequestBody ProductDto productDto) {
        products.add(productDto);
    }

    @PutMapping(value = "updateProduct")
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        Long productId = productDto.getProductId();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId().equals(productId)) {
                products.get(i).setName(productDto.getName());
                products.get(i).setDescription(productDto.getDescription());
            }
        }
        return productDto;
    }

    @DeleteMapping(value = "deleteProduct")
    public void deleteProduct(@RequestParam("Id") long productId) {
        returnListProduct();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId().equals(productId)) {
                products.remove(i);
            }
        }
    }

    private List<ProductDto> returnListProduct() {
        ProductDto computer = new ProductDto(1L, "computer", "Test desc", 34.3, new Group(), false, Collections.emptyList());
        ProductDto laptop = new ProductDto(1L, "laptop", "Test desc", 34.3, new Group(), false, Collections.emptyList());
        if (products.isEmpty()) {
            products.add(computer);
            products.add(laptop);
        }
        return products;
    }
}