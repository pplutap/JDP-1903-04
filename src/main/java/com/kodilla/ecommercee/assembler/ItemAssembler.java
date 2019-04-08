package com.kodilla.ecommercee.Assembler;


import com.kodilla.ecommercee.domain.orders.Item;
import com.kodilla.ecommercee.domain.orders.ItemDto;
import com.kodilla.ecommercee.domain.orders.Order;
import com.kodilla.ecommercee.domain.orders.OrderDto;
import com.kodilla.ecommercee.domain.products.Product;
import com.kodilla.ecommercee.domain.products.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemAssembler {
    public Item productToItem(final Product product){
        return new Item(1L, new Order(), product.getProductId(), product.getName(), product.getDescription(), 1.0, 1.0);
    }

    public ItemDto productToItemDto(final Product product){
        return new ItemDto(1L, new OrderDto(), product.getProductId(), product.getName(), product.getDescription(), 1.0, 1.0);
    }

    public Item productDtoToItem(final ProductDto product){
        return new Item(1L, new Order(), product.getProductId(), product.getName(), product.getDescription(),1.0, 1.0);
    }

    public ItemDto productDtoToItemDto(final ProductDto product){
        return new ItemDto(1L, new OrderDto(), product.getProductId(), product.getName(), product.getDescription(),1.0, 1.0);
    }

    public List<Item> productDtoListToItemList(final List<ProductDto> itemDtos){
        return itemDtos.stream().map(productDto -> productDtoToItem(productDto)).collect(Collectors.toList());
    }

    public List<ItemDto> productDtoListToItemDtoList(final List<ProductDto> itemDtos){
        return itemDtos.stream().map(productDto -> productDtoToItemDto(productDto)).collect(Collectors.toList());
    }

    public List<Item> productListToItemList(final List<Product> products){
        return products.stream().map(product -> productToItem(product)).collect(Collectors.toList());
    }

    public List<ItemDto> productListToItemDtoList(final List<Product> products){
        return products.stream().map(productDto -> productToItemDto(productDto)).collect(Collectors.toList());
    }
}
