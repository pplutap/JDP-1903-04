package com.kodilla.ecommercee.controller;
import com.kodilla.ecommercee.domain.orders.Order;
import com.kodilla.ecommercee.domain.users.User;
import com.kodilla.ecommercee.exceptions.OrderNotFoundException;
import com.kodilla.ecommercee.exceptions.UserNotFoundException;
import com.kodilla.ecommercee.mail.Mail;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import com.kodilla.ecommercee.service.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/order")
public class OrderController {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final SimpleEmailService simpleEmailService;

    @Autowired
    public OrderController(OrderRepository orderRepository, UserRepository userRepository, SimpleEmailService simpleEmailService) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.simpleEmailService = simpleEmailService;
    }

    @GetMapping("/getOrders")
    private List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @PostMapping("/createOrder")
    private void createOrder(@RequestBody Order order){
        orderRepository.save(order);

        Long orderId = order.getId();
        Long userId = order.getUser().getUserId();
        User userToSendMAil = userRepository.findById(userId).orElseThrow(()->new UserNotFoundException(userId));
        simpleEmailService.send(new Mail(
                userToSendMAil.getUserMail(),Mail.SUBJECT,String.format(Mail.TEXT,userToSendMAil.getUsername(), orderId)));
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