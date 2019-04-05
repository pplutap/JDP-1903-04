package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.products.ProductDto;
import com.kodilla.ecommercee.domain.orders.OrderDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        List<ProductDto> updatedProducts = orderDto.getProductDtos();
        for (OrderDto theOrderDto:orders){
            if(orderDto.getOrderId().equals(orderToUpdateId)){
                theOrderDto.setProductDtos(updatedProducts);
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
        List<ProductDto> productDtos1 = new ArrayList<>();
        List<ProductDto> productDtos2 = new ArrayList<>();
        OrderDto orderDto1 = new OrderDto(123L,19L,productDtos1);
        OrderDto orderDto2 = new OrderDto(124L,20L,productDtos2);
        orders.add(orderDto1);
        orders.add(orderDto2);
        return orders;
    }
}