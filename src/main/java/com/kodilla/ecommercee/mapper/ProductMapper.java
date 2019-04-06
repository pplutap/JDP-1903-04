package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.products.Product;
import com.kodilla.ecommercee.domain.products.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    @Autowired
    GroupMapper groupMapper;

    public Product productDtoToProduct(final ItemDto itemDto) {
        return new Product();
    }

    public ItemDto productToProductDto(final Product product){
        return new ItemDto();
    }

    public List<ItemDto> productListToProductDtoList(final List<Product> products) {
        return products.stream().map(product -> new ItemDto()).collect(Collectors.toList());
    }

    public List<Product> productDtoListToProductList(final List<ItemDto> itemDtoList) {
        return itemDtoList.stream()
                .map(productDto -> new Product()).collect(Collectors.toList());
    }
}
