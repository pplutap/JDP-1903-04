package com.kodilla.ecommercee.controller;

<<<<<<< HEAD
import com.kodilla.ecommercee.domain.groups.GroupDto;
import com.kodilla.ecommercee.domain.order.ItemDto;
import com.kodilla.ecommercee.domain.order.OrderDto;
=======
import com.kodilla.ecommercee.domain.group.Group;
import com.kodilla.ecommercee.domain.product.Product;
import com.kodilla.ecommercee.domain.product.ProductDto;
>>>>>>> 1f8caf8cd7ad7c4f02648906c5c592607332b89f
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/product")
public class ProductController {
    private List<ItemDto> products = Collections.emptyList();

    @GetMapping(value = "getProducts")
    public List<ItemDto> getProducts() {
        return returnListProduct();
    }

    @GetMapping(value = "getProduct")
<<<<<<< HEAD
    public ItemDto getProduct(@RequestParam("id") long productId) {
=======
    public ProductDto getProduct(@RequestParam("id") long productId) {
>>>>>>> 1f8caf8cd7ad7c4f02648906c5c592607332b89f
        returnListProduct();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId().equals(productId)) {
                return products.get(i);
            }
        }
        return null;
    }

    @PostMapping(value = "createProduct", consumes = APPLICATION_JSON_VALUE)
    public void createProduct(@RequestBody ItemDto productDto) {
        products.add(productDto);
    }

    @PutMapping(value = "updateProduct")
    public ItemDto updateProduct(@RequestBody ItemDto productDto) {
        Long productId = productDto.getProductId();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId().equals(productId)) {
                products.get(i).setProductName(productDto.getProductName());
                products.get(i).setProductDescription(productDto.getProductDescription());
            }
        }
        return productDto;
    }

    @DeleteMapping(value = "deleteProduct")
    public void deleteProduct(@RequestParam("id") long productId) {
        returnListProduct();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId().equals(productId)) {
                products.remove(i);
            }
        }
    }

<<<<<<< HEAD
    private List<ItemDto> returnListProduct() {
        GroupDto electronic = new GroupDto();
        OrderDto order = new OrderDto();
        ItemDto computer = new ItemDto(1L, order, 1L, "computer", "test", 1.0, 1.0);
        ItemDto laptop = new ItemDto(1L, order, 1L, "laptop", "test", 1.0, 1.0);
=======
    private List<ProductDto> returnListProduct() {
        ProductDto computer = new ProductDto(1L, "computer", "Test desc", 34.3, new Group(), false, Collections.emptyList());
        ProductDto laptop = new ProductDto(1L, "laptop", "Test desc", 34.3, new Group(), false, Collections.emptyList());
>>>>>>> 1f8caf8cd7ad7c4f02648906c5c592607332b89f
        if (products.isEmpty()) {
            products.add(computer);
            products.add(laptop);
        }
        return products;
    }
}