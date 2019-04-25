package com.kodilla.ecommercee.controller;
import com.kodilla.ecommercee.domain.orders.Order;
import com.kodilla.ecommercee.domain.users.User;
import com.kodilla.ecommercee.exceptions.OrderNotFoundException;
import com.kodilla.ecommercee.exceptions.UserNotFoundException;
import com.kodilla.ecommercee.mail.Mail;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import com.kodilla.ecommercee.service.SimpleEmailService;
import com.kodilla.ecommercee.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/order")
public class OrderController {
    private final OrderService orderService;
    private final UserRepository userRepository;
    private final SimpleEmailService simpleEmailService;

    @Autowired
    public OrderController(OrderService orderService, UserRepository userRepository, SimpleEmailService simpleEmailService) {
        this.orderService = orderService;
        this.userRepository = userRepository;
        this.simpleEmailService = simpleEmailService;
    }


    @GetMapping("/getOrders")
    private List<Order> getOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping("/createOrder")
    private void createOrder(@RequestBody Order order){

        orderService.saveOrder(order);

        Long orderId = order.getId();
        Long userId = order.getUser().getUserId();
        User userToSendMAil = userRepository.findById(userId).orElseThrow(()->new UserNotFoundException(userId));
        simpleEmailService.send(new Mail(
                userToSendMAil.getUserMail(),Mail.SUBJECT,String.format(Mail.TEXT,userToSendMAil.getUsername(), orderId)));

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