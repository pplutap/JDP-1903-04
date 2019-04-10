package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.orders.Item;
import com.kodilla.ecommercee.domain.orders.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemMapper {
    @Autowired
    OrderMapper orderMapper;

    public Item itemDtoToItem(final ItemDto item) {
        return new Item(item.getId(), orderMapper.orderDtoToOrder(item.getOrder()), item.getProductId(), item.getProductName(), item.getProductDescription(), item.getPrice(), item.getQuantity());
    }

    public ItemDto itemToItemDto(final Item item) {
        return new ItemDto(item.getId(), orderMapper.orderToOrderDto(item.getOrder()), item.getProductId(), item.getProductName(), item.getProductDescription(), item.getPrice(), item.getQuantity());

    }

    public List<Item> itemDtoListToItemList(final List<ItemDto> productDtos) {
        return productDtos.stream()
                .map(productDto -> itemDtoToItem(productDto))
                .collect(Collectors.toList());
    }

    public List<ItemDto> itemListToItemDtoList(final List<Item> productDtos) {
        return productDtos.stream()
                .map(item -> itemToItemDto(item))
                .collect(Collectors.toList());
    }
}
