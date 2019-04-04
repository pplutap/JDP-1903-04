package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    @Autowired
    GroupMapper groupMapper;

    public Product mapToProduct(final ProductDto productDto) {
        return new Product(productDto.getName(), productDto.getDescription(),groupMapper.mapToGroup(productDto.getGroupDto()));
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> products) {
        return products.stream()
                .map(product -> new ProductDto(product.getProductId(), product.getName(),
                        product.getDescription(),groupMapper.mapToGroupDto(product.getGroup())))
                .collect(Collectors.toList());
    }

    public List<Product> mapToProductList(final List<ProductDto> productDtoList) {
        return productDtoList.stream()
                .map(productDto -> new Product(
                        productDto.getName(),
                        productDto.getDescription(),
                        groupMapper.mapToGroup(productDto.getGroupDto())))
                .collect(Collectors.toList());
    }
}
