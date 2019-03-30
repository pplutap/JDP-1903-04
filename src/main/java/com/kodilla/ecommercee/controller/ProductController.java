package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
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
    public ProductDto getProduct(@RequestParam("productId") long productId) {
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
    public ProductDto updateTask(@RequestBody ProductDto productDto) {
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
    public void deleteTask(@RequestParam("productId") long productId) {
        returnListProduct();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId().equals(productId)) {
                products.remove(i);
            }
        }
    }

    private List<ProductDto> returnListProduct() {
        ProductDto computer = new ProductDto(1L, "computer", "test");
        ProductDto laptop = new ProductDto(2L, "laptop", "test");
        if (products.isEmpty()) {
            products.add(computer);
            products.add(laptop);
        }
        return products;
    }
}