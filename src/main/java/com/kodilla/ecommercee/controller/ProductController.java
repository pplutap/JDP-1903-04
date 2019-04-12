package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.products.Product;
import com.kodilla.ecommercee.domain.products.ProductDto;
import com.kodilla.ecommercee.exceptions.ProductNotFoundException;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @Autowired
    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping(value = "getProducts")
    public List<ProductDto> getProducts() {
        return productMapper.mapToProductDtoList(productService.getAllProducts());
    }

    @GetMapping(value = "getProduct")
    public ProductDto getProduct(@RequestParam("productId") long productId) throws ProductNotFoundException {
        return productMapper.mapToProductDto(productService.getProduct(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId)));
    }

    @PostMapping(value = "createProduct")
    public void createProduct(@RequestBody ProductDto productDto) {
        productService.saveProduct(productMapper.mapToProduct(productDto));
    }

    @PutMapping(value = "updateProduct")
    public ProductDto updateProduct(@RequestBody ProductDto productDto) throws ProductNotFoundException{
        Product product = productService.getProduct(productDto.getProductId())
                .orElseThrow(() -> new ProductNotFoundException(productDto.getProductId()));
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setDeleted(productDto.isDeleted());
        productService.saveProduct(product);

        return productMapper.mapToProductDto(product);
    }

    @DeleteMapping(value = "deleteProduct")
    public void deleteProduct(@RequestParam("productId") long productId) {
        productService.deleteProduct(productId);
    }
}