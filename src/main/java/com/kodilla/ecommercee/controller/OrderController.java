package com.kodilla.ecommercee.controller;

<<<<<<< HEAD
import com.kodilla.ecommercee.domain.carts.Cart;
import com.kodilla.ecommercee.domain.order.ItemDto;
import com.kodilla.ecommercee.domain.order.OrderDto;
import com.kodilla.ecommercee.domain.users.User;
=======
import com.kodilla.ecommercee.domain.order.Item;
import com.kodilla.ecommercee.domain.order.Order;
import com.kodilla.ecommercee.domain.order.OrderDto;
import com.kodilla.ecommercee.domain.user.User;
>>>>>>> 1f8caf8cd7ad7c4f02648906c5c592607332b89f
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.Collections;
=======
import java.util.Arrays;
>>>>>>> 1f8caf8cd7ad7c4f02648906c5c592607332b89f
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

    List<OrderDto> orders = Collections.emptyList();

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
        List<ItemDto> updatedProducts = orderDto.getItems();
        for (OrderDto theOrderDto:orders){
            if(orderDto.getOrderId().equals(orderToUpdateId)){
                theOrderDto.setItems(updatedProducts);
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

<<<<<<< HEAD
    private List<OrderDto> getOrderDtos(){
        User user = new User(1L, "TestName", 11232L, new Cart(), User.Status.NOT_BANNED, Collections.emptyList());
        List<ItemDto> productDtos1 = new ArrayList<>();
        List<ItemDto> productDtos2 = new ArrayList<>();
        OrderDto orderDto1 = new OrderDto(123L, new Date(), user,productDtos1, true);
        OrderDto orderDto2 = new OrderDto(123L, new Date(), user,productDtos2, false);
        orders.add(orderDto1);
        orders.add(orderDto2);
=======
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
>>>>>>> 1f8caf8cd7ad7c4f02648906c5c592607332b89f
        return orders;
    }
}