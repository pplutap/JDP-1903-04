package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.orders.Item;
import com.kodilla.ecommercee.domain.orders.OrderDto;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/order")
public class OrderController {
    //lista wszystkich zamówień ok
    //dodanie nowego zamówienia ok
    //wyświetlenie zamówienia ok
    //aktualizacja zamówienia ok
    //usunięcie zamówienia ok

    Item item0 = new Item(0L,0,new BigDecimal("0"));
    Item item1 = new Item(10125L,3,new BigDecimal("124.99"));
    Item item2 = new Item(10126L,1,new BigDecimal("299"));
    Item item3 = new Item(10127L,9,new BigDecimal("32.5"));
    OrderDto order0 = new OrderDto(0L, Arrays.asList(item0));
    OrderDto order1 = new OrderDto(123L, Arrays.asList(item1,item2));
    OrderDto order2 = new OrderDto(124L, Arrays.asList(item2,item3));
    List<OrderDto> orders = new ArrayList<>();


    @GetMapping("/getOrders")
    private List<OrderDto> getOrders() {
        orders.add(order1);
        orders.add(order2);
        return orders;
    }

    @PostMapping("/createOrder")
    private void createOrder(@RequestBody OrderDto orderDto){
        System.out.println(orders);
        orders.add(orderDto);
        System.out.println(orders);
    }

    @GetMapping("/getOrder")
    private OrderDto getOrder(@RequestParam("orderId") long orderId){
        orders.add(order2);
        OrderDto result = order0;
        for (OrderDto order:orders) {
            if(order.getOrderId() == orderId){
                result = order;
            }
        }
        return result;
    }

    @PutMapping("/updateOrder")
    private OrderDto updateOrder(@RequestBody OrderDto orderDto){
        OrderDto result = order0;
        Long orderToUpdateId = orderDto.getOrderId();
        List<Item> updatedItems = orderDto.getItems();
        for (OrderDto order:orders){
            if(order.getOrderId().equals(orderToUpdateId)){
                order.setItems(updatedItems);
                result=order;
            }
        }
        return result;
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

}
