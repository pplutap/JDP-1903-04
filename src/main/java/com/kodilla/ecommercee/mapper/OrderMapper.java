package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.orders.Order;
import com.kodilla.ecommercee.domain.orders.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {
    @Autowired
    ItemMapper itemMapper;
    @Autowired
    private UserMapper userMapper;

    public Order orderDtoToOrder(OrderDto orderDto){
        return new Order(orderDto.getOrderId(), orderDto.getDate(), userMapper.userDtoToUser(orderDto.getUser()), itemMapper.itemDtoListToItemList(orderDto.getItems()), orderDto.getPaid());
    }

    public OrderDto orderToOrderDto(Order order){
        return new OrderDto(order.getId(), order.getDate(), userMapper.userToUserDto(order.getUser()), itemMapper.itemListToItemDtoList(order.getItems()), order.isPaid());
    }

    public List<Order> orderDtoListoToOrderList(List<OrderDto> orderDtos){
        return orderDtos.stream().map(orderDto -> orderDtoToOrder(orderDto)).collect(Collectors.toList());
    }

    public List<OrderDto> orderListToOrderDtoList(List<Order> orders){
        return orders.stream().map(order -> orderToOrderDto(order)).collect(Collectors.toList());
    }
}