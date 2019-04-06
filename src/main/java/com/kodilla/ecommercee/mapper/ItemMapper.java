package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.order.Item;
<<<<<<< HEAD
import com.kodilla.ecommercee.domain.order.ItemDto;
import com.kodilla.ecommercee.domain.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
=======
import com.kodilla.ecommercee.domain.order.Order;
import com.kodilla.ecommercee.domain.product.Product;
import com.kodilla.ecommercee.domain.product.ProductDto;
>>>>>>> 1f8caf8cd7ad7c4f02648906c5c592607332b89f
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemMapper {
<<<<<<< HEAD
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
=======
    public Item productDtoToItemDto(final ProductDto productDto){
        return new Item(1L, new Order(), productDto.getProductId(), productDto.getName(), productDto.getDescription(), productDto.getPrice(), 1.0);
    }

    public List<Item> productDtoListToItemList(final List<ProductDto> productDtos){
        return productDtos.stream()
                .map(productDto -> productDtoToItemDto(productDto))
>>>>>>> 1f8caf8cd7ad7c4f02648906c5c592607332b89f
                .collect(Collectors.toList());
    }
}
