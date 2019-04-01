package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public Product mapToProduct(final ProductDto productDto) {
        return new Product(productDto.getProductId(), productDto.getName(), productDto.getDescription());
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> products) {
        return products.stream()
                .map(product -> new ProductDto(product.getProductId(), product.getName(), product.getDescription()))
                .collect(Collectors.toList());
    }

    public List<Product> mapToProductList(final List<ProductDto> productDtoList) {
        return productDtoList.stream()
                .map(productDto -> new Product(productDto.getProductId(), productDto.getName(), productDto.getDescription()))
                .collect(Collectors.toList());
    }
}
