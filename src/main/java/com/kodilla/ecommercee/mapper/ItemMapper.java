package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.order.Item;
import com.kodilla.ecommercee.domain.order.Order;
import com.kodilla.ecommercee.domain.product.Product;
import com.kodilla.ecommercee.domain.product.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemMapper {
    public Item productDtoToItemDto(final ProductDto productDto){
        return new Item(1L, new Order(), productDto.getProductId(), productDto.getName(), productDto.getDescription(), productDto.getPrice(), 1.0);
    }

    public List<Item> productDtoListToItemList(final List<ProductDto> productDtos){
        return productDtos.stream()
                .map(productDto -> productDtoToItemDto(productDto))
                .collect(Collectors.toList());
    }
}
