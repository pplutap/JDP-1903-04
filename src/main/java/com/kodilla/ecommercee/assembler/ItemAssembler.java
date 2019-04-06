package com.kodilla.ecommercee.assembler;

import com.kodilla.ecommercee.domain.order.Item;
import com.kodilla.ecommercee.domain.order.ProductDto;
import com.kodilla.ecommercee.domain.order.Order;
import com.kodilla.ecommercee.domain.order.OrderDto;
import com.kodilla.ecommercee.domain.products.ItemDto;
import com.kodilla.ecommercee.domain.products.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemAssembler {
    public Item productToItem(final Product product){
        return new Item(1L, new Order(), product.getId(), product.getName(), product.getDescription(), 1.0, 1.0);
    }

    public ProductDto productToItemDto(final Product product){
        return new ProductDto(1L, new OrderDto(), product.getId(), product.getName(), product.getDescription(), 1.0, 1.0);
    }

    public Item productDtoToItem(final ItemDto product){
        return new Item(1L, new Order(), product.getId(), product.getName(), product.getDescription(),1.0, 1.0);
    }

    public ProductDto productDtoToItemDto(final ItemDto product){
        return new ProductDto(1L, new OrderDto(), product.getId(), product.getName(), product.getDescription(),1.0, 1.0);
    }

    public List<ProductDto> productDtoListToItemDtoList(final List<ItemDto> itemDtos){
        return itemDtos.stream().map(productDto -> productDtoToItemDto(productDto)).collect(Collectors.toList());
    }

    public List<ProductDto> productListToItemDtoList(final List<Product> products){
        return products.stream().map(productDto -> productToItemDto(productDto)).collect(Collectors.toList());
    }

    public List<Item> productDtoListToItemList(final List<ItemDto> itemDtos){
        return itemDtos.stream().map(productDto -> productDtoToItem(productDto)).collect(Collectors.toList());
    }

    public List<Item> productListToItemList(final List<Product> products){
        return products.stream().map(product -> productToItem(product)).collect(Collectors.toList());
    }
}
