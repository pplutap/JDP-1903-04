package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.order.ItemDto;
import com.kodilla.ecommercee.domain.order.OrderDto;
import com.kodilla.ecommercee.domain.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    @Autowired
    GroupMapper groupMapper;

    public Product mapToProduct(final ItemDto productDto) {
        return new Product();
    }

    public List<ItemDto> mapToProductDtoList(final List<Product> products) {
        return products.stream()
                .map(product -> new ItemDto(1L, new OrderDto(), product.getId(), product.getName(), product.getDescription(), 1.0, 1.0)).collect(Collectors.toList());
    }

    public List<Product> mapToProductList(final List<ItemDto> productDtoList) {
        return productDtoList.stream()
                .map(productDto -> new Product()).collect(Collectors.toList());
    }
}
