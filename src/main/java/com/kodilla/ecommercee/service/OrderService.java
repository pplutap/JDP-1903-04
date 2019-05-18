package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.orders.Order;
import com.kodilla.ecommercee.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order saveOrder(final Order order) {
        return orderRepository.save(order);
    }

    public Optional<Order> getOrderById(final Long id) {
        return orderRepository.findById(id);
    }

    public void deleteOrder(final Long id) {
        orderRepository.deleteById(id);
    }

    public void closeOrder(final Long id) {
        orderRepository.closeOrder(id);
    }
}

