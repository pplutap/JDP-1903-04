package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.carts.Cart;
import com.kodilla.ecommercee.domain.orders.Order;
import com.kodilla.ecommercee.domain.users.User;
import com.kodilla.ecommercee.domain.users.UserBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void saveUserTest(){
        //Given
        User user = new UserBuilder().createUser();
        //When
        List<User> usersBefore = userRepository.findAll();
        userRepository.save(user);
        //Then
        List<User> usersAfter = userRepository.findAll();
        assertEquals(usersBefore.size()+1, usersAfter.size());
        //CleanUp
        try{
            userRepository.delete(user);
        }catch (Exception e){
        }
    }

    @Test
    public void findByIdTest(){
        //Given
        User user = new UserBuilder().createUser();
        //When
        userRepository.save(user);
        //Then
        Long userId = user.getUserId();
        Optional<User> testUser = userRepository.findById(userId);
        User userToTest = testUser.get();
        assertEquals(userId, userToTest.getUserId());
        //CleanUp
        try{
            userRepository.delete(user);
        }catch (Exception e){
        }
    }

    @Test
    public void relationUserCartTest(){
        //Given
        Cart cart = new Cart();
        User user = new UserBuilder().createUser();
        user.setCart(cart);
        //When
        userRepository.save(user);
        //Then
        Long userId = user.getUserId();
        Long cartId = cart.getCartId();
        Optional<User> testUser = userRepository.findById(userId);
        User userToTest = testUser.get();
        assertEquals(userToTest.getCart().getCartId(), cartId);
        //CleanUp
        try{
            userRepository.delete(user);
            cartRepository.delete(cart);
        }catch (Exception e){
        }
    }

    @Test
    public void relationUserOrderTest(){
        //Given
        User user = new UserBuilder().setOrders(new ArrayList<>()).createUser();
        Order order1 = new Order(LocalDate.now(), user, new ArrayList<>(), false);
        Order order2 = new Order(LocalDate.now(), user, new ArrayList<>(), true);
        user.getOrders().add(order1);
        user.getOrders().add(order2);
        //When
        userRepository.save(user);
        Long userId = user.getUserId();
        Optional<User> testUser = userRepository.findById(userId);
        User userToTest = testUser.get();
        int expected = 2;
        //Then
        assertEquals(expected, userToTest.getOrders().size());
        //CleanUp
        try{
            userRepository.delete(user);
            orderRepository.delete(order1);
            orderRepository.delete(order2);
        }catch (Exception e){
        }
    }

}