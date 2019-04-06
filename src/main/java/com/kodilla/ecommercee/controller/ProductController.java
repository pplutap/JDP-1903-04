package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.groups.Group;
import com.kodilla.ecommercee.domain.products.Product;
import com.kodilla.ecommercee.domain.products.ProductDto;
import com.kodilla.ecommercee.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/product")
public class ProductController {
    @Autowired
    ProductMapper productMapper;

    private List<Product> products = Collections.emptyList();
    private List<ProductDto> productsDto = Collections.emptyList();

    @GetMapping(value = "getProducts")
    public List<ProductDto> getProducts() {
        return returnListProduct();
    }

    @GetMapping(value = "getProduct")
    public ProductDto getProduct(@RequestParam("id") long productId) {
        returnListProduct();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(productId)) {
                return productsDto.get(i);
            }
        }
        return null;
    }

    @PostMapping(value = "createProduct", consumes = APPLICATION_JSON_VALUE)
    public void createProduct(@RequestBody ProductDto productDto) {
        productsDto.add(productDto);
    }

    @PutMapping(value = "updateProduct")
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        Long productId = productDto.getId();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(productId)) {
                products.get(i).setName(productDto.getName());
                products.get(i).setDescription(productDto.getDescription());
            }
        }
        return productDto;
    }

    @DeleteMapping(value = "deleteProduct")
    public void deleteProduct(@RequestParam("id") long productId) {
        returnListProduct();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(productId)) {
                products.remove(i);
            }
        }
    }

    private List<ProductDto> returnListProduct() {
        ProductDto computer = new ProductDto(1L, "computer", "Test desc",Collections.emptyList(), new Group());
        ProductDto laptop = new ProductDto(1L, "laptop", "Test desc", Collections.emptyList(), new Group());
        if (productsDto.isEmpty()) {
            productsDto.add(computer);
            productsDto.add(laptop);
        }
        return productsDto;
    }
}