package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.controller.Exception.CartNotFoundException;
import com.kodilla.ecommercee.controller.Exception.UserNotFoundException;
import com.kodilla.ecommercee.domain.carts.Cart;
import com.kodilla.ecommercee.domain.orders.Item;
import com.kodilla.ecommercee.domain.orders.Order;
import com.kodilla.ecommercee.domain.products.Product;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final ItemService itemService;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public CartService(CartRepository cartRepository, ProductRepository productRepository,
                       ItemService itemService, UserRepository userRepository,
                       OrderRepository orderRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.itemService = itemService;
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    public List<Item> getAllItemInCart(long id) throws CartNotFoundException {
        return cartRepository.findById(id).orElseThrow(CartNotFoundException::new).getItems();
    }

    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public void createOrderBaseOnCart(Long userId) throws UserNotFoundException {
        List<Item> items = userRepository.findById(userId).orElseThrow(UserNotFoundException::new)
                .getCart().getItems();
        Order order = new Order(LocalDate.now(), false, items);
        orderRepository.save(order);
    }

    public void addItemToCart(Long productId, Long cartId, int quantity) throws CartNotFoundException {
        Product productById = productRepository.getOne(productId);
        Item item = new Item(productId, productById.getName(), productById.getDescription(), productById.getPrice(), quantity);
        itemService.saveItem(item);
        cartRepository.findById(cartId).orElseThrow(CartNotFoundException::new).getItems().add(item);
    }

    public void deleteItemFromCart(Long itemId, Long cartId) throws CartNotFoundException {
        cartRepository.findById(cartId).orElseThrow(CartNotFoundException::new).
                getItems().remove(itemService.findItemById(itemId));
    }
}