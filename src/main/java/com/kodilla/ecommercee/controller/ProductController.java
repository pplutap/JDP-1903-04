package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.products.Product;
import com.kodilla.ecommercee.domain.products.ProductDto;
import com.kodilla.ecommercee.exceptions.ProductNotFoundException;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.ProductService;
import com.opencsv.CSVReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
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

    @PostMapping(value = "addNewProducts")
    public void addNewsFromCSV(@RequestParam String header)throws IOException {

        List<List<String>> records = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new FileReader("resources/products.csv"));) {
            String[] values = null;

            if(header.equalsIgnoreCase("yes")){
                csvReader.readNext();
            }

            while ((values = csvReader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }
        }catch (IOException e){

        }

        for (List<String> list:records) {
            String[] array = list.get(0).split(";");

            productService.saveProduct(new Product(array[0],array[1],new BigDecimal(array[2])));
        }
    }
}