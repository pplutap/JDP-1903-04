package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.product.Product;
import com.kodilla.ecommercee.domain.product.ProductDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public Product mapToProduct(final ProductDto productDto) {
        return new Product(productDto.getProductId(), productDto.getName(), productDto.getDescription(), productDto.getPrice(), productDto.getGroup(), productDto.getDeleted(), productDto.getCarts());
    }

    //Do zrobienia GroupMapper
    public ProductDto mapToProductDto(final Product product){
        return new ProductDto(product.getProductId(), product.getName(), product.getDescription(), product.getPrice(), product.getGroup(), product.getDeleted(), product.getCarts());
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> products) {
        return products.stream()
                .map(product -> new ProductDto(product.getProductId(), product.getName(), product.getDescription(), product.getPrice(), product.getGroup(), product.getDeleted(), product.getCarts()))
                .collect(Collectors.toList());
    }

    public List<Product> mapToProductList(final List<ProductDto> productDtoList) {
        return productDtoList.stream()
                .map(productDto -> new Product(productDto.getProductId(), productDto.getName(), productDto.getDescription(), productDto.getPrice(), productDto.getGroup(), productDto.getDeleted(), productDto.getCarts()))
                .collect(Collectors.toList());
    }
}
