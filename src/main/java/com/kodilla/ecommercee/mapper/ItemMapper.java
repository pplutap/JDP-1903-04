package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.order.Item;
import com.kodilla.ecommercee.domain.order.ItemDto;
import com.kodilla.ecommercee.domain.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemMapper {
    @Autowired
    OrderMapper orderMapper;

    public Item itemDtoToItem(final ItemDto itemDto){
        return new Item(itemDto.getItemId(), orderMapper.OrderDtoToOrder(itemDto.getOrder()), itemDto.getProductId(), itemDto.getProductName(), itemDto.getProductDescription(), itemDto.getPrice(), itemDto.getQuantity());
    }

    public ItemDto itemToItemDto(final Item item){
        return new ItemDto(item.getId(), orderMapper.OrderToOrderDto(item.getOrder()), item.getProductId(), item.getProductName(), item.getProductDescription(), item.getPrice(), item.getQuantity());

    }

    public List<Item> itemDtoListToItemList(final List<ItemDto> itemDtos){
        return itemDtos.stream()
                .map(productDto -> itemDtoToItem(productDto))
                .collect(Collectors.toList());
    }

    public List<ItemDto> itemListToItemDtoList(final List<Item> productDtos){
        return productDtos.stream()
                .map(item -> itemToItemDto(item))
                .collect(Collectors.toList());
    }
}
