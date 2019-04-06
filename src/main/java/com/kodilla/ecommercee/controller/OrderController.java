package com.kodilla.ecommercee.controller;
import com.kodilla.ecommercee.domain.carts.Cart;
import com.kodilla.ecommercee.domain.orders.OrderDto;
import com.kodilla.ecommercee.domain.orders.ItemDto;
import com.kodilla.ecommercee.domain.users.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
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

    private List<OrderDto> getOrderDtos(){
        User user = new User("TestName", false, new Cart());
        List<ItemDto> productDtos1 = new ArrayList<>();
        List<ItemDto> productDtos2 = new ArrayList<>();
        OrderDto orderDto1 = new OrderDto(123L, new Date(), user,productDtos1, true);
        OrderDto orderDto2 = new OrderDto(123L, new Date(), user,productDtos2, false);
        orders.add(orderDto1);
        orders.add(orderDto2);
        return orders;
    }
}