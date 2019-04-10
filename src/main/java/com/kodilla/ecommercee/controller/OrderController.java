package com.kodilla.ecommercee.controller;
import com.kodilla.ecommercee.domain.carts.Cart;
import com.kodilla.ecommercee.domain.orders.Order;
import com.kodilla.ecommercee.domain.orders.OrderDto;
import com.kodilla.ecommercee.domain.orders.ItemDto;
import com.kodilla.ecommercee.domain.users.User;
import com.kodilla.ecommercee.exceptions.OrderNotFoundException;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/order")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderMapper orderMapper;

    @GetMapping("/getOrders")
    private List<OrderDto> getOrders() {
        return orderMapper.orderListToOrderDtoList(orderRepository.findAll());
    }

    @PostMapping("/createOrder")
    private void createOrder(@RequestBody OrderDto orderDto){
        orderRepository.save(orderMapper.orderDtoToOrder(orderDto));
    }

    @GetMapping("/getOrder")
    private OrderDto getOrder(@RequestParam("orderId") long orderId) throws OrderNotFoundException {
        return orderRepository.findById(orderId)
                .map(orderMapper::orderToOrderDto)
                .orElseThrow(OrderNotFoundException::new);
    }

    @PutMapping("/updateOrder")
    private OrderDto updateOrder(@RequestBody OrderDto orderDto) throws OrderNotFoundException {
        orderRepository.save(orderMapper.orderDtoToOrder(orderDto));
        return orderRepository.findById(orderDto.getOrderId())
                .map(orderMapper::orderToOrderDto)
                .orElseThrow(OrderNotFoundException::new);
    }

    @DeleteMapping("/deleteOrder")
    public void deleteOrder(@RequestParam("id") long id){
        orderRepository.deleteById(id);
    }
}