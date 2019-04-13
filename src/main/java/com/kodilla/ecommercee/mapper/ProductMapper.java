package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.products.Product;
import com.kodilla.ecommercee.domain.products.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public Product mapToProduct(final ProductDto productDto) {
        return new Product(productDto.getName(), productDto.getDescription(), productDto.getPrice(), productDto.getQuantity());
    }

    public ProductDto mapToProductDto(final Product product){
        return new ProductDto(product.getProductId(),product.getName(),
                product.getDescription(),product.getPrice(),product.isDeleted(), product.getQuantity());
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> products) {
        return products.stream()
                .map(product -> new ProductDto(product.getProductId(), product.getName(), product.getDescription(),
                        product.getPrice(), product.isDeleted(), product.getQuantity()))
                .collect(Collectors.toList());
    }

    public List<Product> mapToProductList(final List<ProductDto> productDtoList) {
        return productDtoList.stream()
                .map(productDto -> new Product(productDto.getName(), productDto.getDescription(),
                        productDto.getPrice(), productDto.getQuantity()))
                .collect(Collectors.toList());
    }
}