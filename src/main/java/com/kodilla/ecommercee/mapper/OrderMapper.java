package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.order.Order;
import com.kodilla.ecommercee.domain.order.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    @Autowired
    ItemMapper itemMapper;

    public Order orderDtoToOrder(OrderDto orderDto){
        return new Order(orderDto.getOrderId(), orderDto.getDate(), orderDto.getUser(),itemMapper.itemDtoListToItemList(orderDto.getItems()),orderDto.getPaid());
    }

    public OrderDto orderToOrderDto(Order order){
        return new OrderDto(order.getId(), order.getDate(), order.getUser(), itemMapper.itemListToItemDtoList(order.getItems()), order.getPaid());
    }
}
