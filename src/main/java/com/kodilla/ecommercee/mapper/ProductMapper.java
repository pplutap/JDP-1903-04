package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.products.Product;
import com.kodilla.ecommercee.domain.products.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public Product mapToProduct(final ProductDto productDto) {
        return new Product.ProductBuilder()
                        .name(productDto.getName())
                        .description(productDto.getDescription())
                        .price(productDto.getPrice())
                        .quantity(productDto.getQuantity())
                        .build();
    }

    public ProductDto mapToProductDto(final Product product) {
        return new ProductDto.ProductDtoBuilder()
                .productId(product.getProductId())
                .name(product.getName())
                .description(product.getDescription())
                .deleted()
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> products) {
        return products.stream()
                .map(product -> new ProductDto.ProductDtoBuilder()
                        .productId(product.getProductId())
                        .name(product.getName())
                        .description(product.getDescription())
                        .deleted()
                        .price(product.getPrice())
                        .quantity(product.getQuantity())
                        .build())
                .collect(Collectors.toList());
    }

    public List<Product> mapToProductList(final List<ProductDto> productDtoList) {
        return productDtoList.stream()
                .map(productDto -> new Product.ProductBuilder()
                        .name(productDto.getName())
                        .description(productDto.getDescription())
                        .price(productDto.getPrice())
                        .quantity(productDto.getQuantity())
                        .build())
                .collect(Collectors.toList());
    }
}