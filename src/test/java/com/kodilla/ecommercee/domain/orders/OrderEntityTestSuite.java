package com.kodilla.ecommercee.domain.orders;

import com.kodilla.ecommercee.domain.users.User;
import com.kodilla.ecommercee.repository.ItemRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderEntityTestSuite {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    @After
    public void deleteAllData() {
        orderRepository.deleteAll();
        userRepository.deleteAll();
        itemRepository.deleteAll();
    }

    @Test
    public void testOrderSaveWithItems() {
        //Given
        Item item1 = new Item.ItemBuilder()
                         .productId(1L)
                         .productName("TestName1")
                         .productDescription("TestDesc1")
                         .price(new BigDecimal(2.5))
                         .quantity(2)
                         .build();
        Item item2 = new Item.ItemBuilder()
                        .productId(2L)
                        .productName("TestName2")
                        .productDescription("TestDesc2")
                        .price(new BigDecimal(2.5))
                        .quantity(3)
                        .build();
        Order order = new Order();
        order.getItems().add(item1);
        order.getItems().add(item2);
        item1.setOrder(order);
        item2.setOrder(order);
        //When
        orderRepository.save(order);
        Long item1Id = item1.getId();
        Long orderId = order.getId();
        //Then
        assertNotEquals(null, orderId);
        assertEquals(order.getItems().get(0).getId(), item1Id);
        assertEquals(1, orderRepository.count());
        assertEquals(2, itemRepository.count());
    }

    @Test
    public void testOrderSaveWhenOrderIsEmpty() {
        //Given
        Order order = new Order();
        //When
        orderRepository.save(order);
        Long orderId = order.getId();
        //Then
        assertNotEquals(null, orderId);
        assertEquals(itemRepository.count(), order.getItems().size());
        assertEquals(1, orderRepository.count());
    }

    @Test
    public void testOrderSaveWhenListOfItemsIsEmpty() {
        //Given
        List<Item> emptyList = new ArrayList<>();

        Order order = new Order();
        order.setItems(emptyList);
        //When
        orderRepository.save(order);
        Long orderId = order.getId();
        List<Item> items = itemRepository.findAll();
        //Then
        assertNotEquals(null, orderId);
        assertEquals(1, orderRepository.count());
        assertEquals(0, itemRepository.count());
        assertTrue(items.isEmpty());
    }

    @Test
    public void testOrderSaveWhenItemIsNull() {
        //Given
        Item item1 = null;
        Item item2 = new Item.ItemBuilder()
                .productId(2L)
                .productName("TestName2")
                .productDescription("TestDesc2")
                .price(new BigDecimal(3.5))
                .quantity(1)
                .build();
        Order order = new Order();
        order.getItems().add(item1);
        order.getItems().add(item2);
        item2.setOrder(order);
        //When
        orderRepository.save(order);
        Long item2Id = item2.getId();
        Long orderId = order.getId();
        //Then
        assertNotEquals(null, orderId);
        assertEquals(order.getItems().get(1).getId(), item2Id);
        assertEquals(1, itemRepository.count());
    }

    @Test
    public void testOrderSaveWhenListOfItemsIsNull() {
        //Given
        List<Item> itemList = null;

        Order order = new Order();
        order.setItems(itemList);
        //When
        orderRepository.save(order);
        Long orderId = order.getId();
        List<Item> items = itemRepository.findAll();

        //Then
        assertNotEquals(null, orderId);
        assertEquals(1, orderRepository.count());
        assertEquals(0, itemRepository.count());
        assertTrue(items.isEmpty());
    }

    @Test
    public void testUserSaveWithOrders() {
        //Given
        Order order1 = new Order();
        Order order2 = new Order();

        User user = new User();

        user.getOrders().add(order1);
        user.getOrders().add(order2);

        order1.setUser(user);
        order2.setUser(user);

        //When
        userRepository.save(user);
        Long userId = user.getUserId();
        Long order1Id = order1.getId();
        Long order2Id = order2.getId();

        //Then
        assertNotEquals(null, userId);
        assertNotEquals(null, order1Id);
        assertNotEquals(null, order2Id);
        assertEquals(2, orderRepository.count());
    }
}
