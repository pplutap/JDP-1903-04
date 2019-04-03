package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.order.Item;
import com.kodilla.ecommercee.domain.order.Order;
import com.kodilla.ecommercee.domain.order.OrderDto;
import com.kodilla.ecommercee.domain.user.User;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/order")
public class OrderController {
    //lista wszystkich zamówień ok
    //dodanie nowego zamówienia ok
    //wyświetlenie zamówienia ok
    //aktualizacja zamówienia ok
    //usunięcie zamówienia ok

    List<OrderDto> orders = new ArrayList<>();

    @GetMapping("/getOrders")
    private List<OrderDto> getOrders() {
        return getOrderDtos();
    }

    @PostMapping("/createOrder")
    private void createOrder(@RequestBody OrderDto orderDto){
        orders.add(orderDto);
    }

    @GetMapping("/getOrder")
    private OrderDto getOrder(@RequestParam("orderId") long orderId){
        getOrderDtos();
        for (OrderDto order:orders) {
            if(order.getOrderId() == orderId){
                return order;
            }
        }
        return null;
    }

    @PutMapping("/updateOrder")
    private OrderDto updateOrder(@RequestBody OrderDto orderDto){
        Long orderToUpdateId = orderDto.getOrderId();
        List<Item> updatedItems = orderDto.getItems();
        for (OrderDto order:orders){
            if(order.getOrderId().equals(orderToUpdateId)){
                order.setItems(updatedItems);
            }
        }
        return orderDto;
    }

    @DeleteMapping("/deleteOrder")
    public void deleteOrder(@RequestParam("id") long id){
        getOrders();
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderId().equals(id)) {
                orders.remove(i);
            }
        }
    }

    private List<Item> getItems1(){
        Item item1 = new Item(10125L,new Order(), 123L, "Test product name", "Test product desc", 43.12, 23.4);
        Item item2 = new Item(10145L,new Order(), 123L, "Test product name", "Test product desc", 43.12, 23.4);
        return Arrays.asList(item1,item2);
    }

    private List<Item> getItems2(){
        Item item2 = new Item(101654L,new Order(), 123L, "Test product name", "Test product desc", 43.12, 23.4);
        Item item3 = new Item(101123L,new Order(), 123L, "Test product name", "Test product desc", 43.12, 23.4);
        return Arrays.asList(item2,item3);
    }

    private List<OrderDto> getOrderDtos(){
        OrderDto order1 = new OrderDto(123L, new Date(), new User(), getItems1(), false);
        OrderDto order2 = new OrderDto(324L, new Date(), new User(), getItems2(), false);
        orders.add(order1);
        orders.add(order2);
        return orders;
    }
}