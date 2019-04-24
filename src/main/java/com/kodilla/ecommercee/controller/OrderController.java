package com.kodilla.ecommercee.controller;
import com.kodilla.ecommercee.domain.orders.Order;
import com.kodilla.ecommercee.exceptions.OrderNotFoundException;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/getOrders")
    private List<Order> getOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping("/createOrder")
    private void createOrder(@RequestBody Order order){
        orderService.saveOrder(order);
    }

    @GetMapping("/getOrder")
    private Order getOrder(@RequestParam("orderId") long orderId) throws OrderNotFoundException {
        return orderService.getOrderById(orderId)
                .orElseThrow(OrderNotFoundException::new);
    }

    @PutMapping("/updateOrder")
    private Order updateOrder(@RequestBody Order order) throws OrderNotFoundException {
        orderService.saveOrder(order);
        return orderService.getOrderById(order.getId())
                .orElseThrow(OrderNotFoundException::new);
    }

    @DeleteMapping("/deleteOrder")
    public void deleteOrder(@RequestParam("id") long id){
        orderService.deleteOrder(id);
    }
}