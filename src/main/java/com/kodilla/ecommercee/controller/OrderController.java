package com.kodilla.ecommercee.controller;
import com.kodilla.ecommercee.domain.orders.Order;
import com.kodilla.ecommercee.exceptions.OrderNotFoundException;
import com.kodilla.ecommercee.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/order")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/getOrders")
    private List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @PostMapping("/createOrder")
    private void createOrder(@RequestBody Order order){
        orderRepository.save(order);
    }

    @GetMapping("/getOrder")
    private Order getOrder(@RequestParam("orderId") long orderId) throws OrderNotFoundException {
        return orderRepository.findById(orderId)
                .orElseThrow(OrderNotFoundException::new);
    }

    @PutMapping("/updateOrder")
    private Order updateOrder(@RequestBody Order order) throws OrderNotFoundException {
        orderRepository.save(order);
        return orderRepository.findById(order.getId())
                .orElseThrow(OrderNotFoundException::new);
    }

    @DeleteMapping("/deleteOrder")
    public void deleteOrder(@RequestParam("id") long id){
        orderRepository.deleteById(id);
    }
}