package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.products.Product;
import com.kodilla.ecommercee.domain.products.ProductDto;
import com.kodilla.ecommercee.exceptions.ProductNotFoundException;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.ProductService;
import com.opencsv.CSVReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/product")
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

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
        return productMapper.mapToProductDto(productService.getProductById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId)));
    }

    @PostMapping(value = "createProduct")
    public void createProduct(@RequestBody ProductDto productDto) {
        productService.saveProduct(productMapper.mapToProduct(productDto));
    }

    @PutMapping(value = "updateProduct")
    public ProductDto updateProduct(@RequestBody ProductDto productDto) throws ProductNotFoundException{
        Product product = productService.getProductById(productDto.getProductId())
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

        try (CSVReader csvReader = new CSVReader(new FileReader("resources/products.csv"));) {
            String[] values = null;

            if(header.equalsIgnoreCase("yes")){
                csvReader.readNext();
            }

            while ((values = csvReader.readNext()) != null) {

                values = values[0].split(";");
                productService.saveProduct(new Product(values[0],values[1],new BigDecimal(values[2]),0));

            }
        }catch (IOException e){
            LOGGER.error("Failed to process import form .CSV file: ", e.getMessage(), e);
        }
    }
}