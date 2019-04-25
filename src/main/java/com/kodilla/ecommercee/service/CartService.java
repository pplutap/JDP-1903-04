package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.controller.exception.CartNotFoundException;
import com.kodilla.ecommercee.controller.exception.ItemNotFoundException;
import com.kodilla.ecommercee.controller.exception.ProductNotFoundException;
import com.kodilla.ecommercee.controller.exception.UserNotFoundException;
import com.kodilla.ecommercee.domain.carts.Cart;
import com.kodilla.ecommercee.domain.orders.Item;
import com.kodilla.ecommercee.domain.orders.Order;
import com.kodilla.ecommercee.domain.products.Product;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class CartService {
    private final CartRepository cartRepository;
    private final ProductService productService;
    private final ItemService itemService;
    private final OrderRepository orderRepository;

    @Autowired
    public CartService(CartRepository cartRepository, ProductService productService,
                       ItemService itemService, OrderRepository orderRepository) {
        this.cartRepository = cartRepository;
        this.productService = productService;
        this.itemService = itemService;
        this.orderRepository = orderRepository;
    }

    public List<Item> getAllProductInCart(long cartId) throws CartNotFoundException {
        List<Item> items = cartRepository.findById(cartId).orElseThrow(CartNotFoundException::new).getItems();
        updatePriceOfItemAfterChangePriceOfProduct(items);
        return items;
    }

    private void updatePriceOfItemAfterChangePriceOfProduct(List<Item> items) {
        List<Product> products = productService.getAllProducts();
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            Long productIdOfItem = item.getProductId();
            for (int j = 0; j < products.size(); j++) {
                Long productIdOfProduct = products.get(j).getProductId();
                if (productIdOfItem.equals(productIdOfProduct)) {
                    Item itemToChangePrice = itemService.getItem(item.getId());
                    itemToChangePrice.setPrice(productService.getProduct(productIdOfProduct).getPrice());
                    itemService.saveItem(itemToChangePrice);
                }
            }
        }
    }

    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public void createOrderBaseOnCart(Long cartId) throws UserNotFoundException {
        List<Item> items = cartRepository.findById(cartId).orElseThrow(UserNotFoundException::new)
                .getItems();
        Order order = new Order(LocalDate.now(), false, items);
        orderRepository.save(order);
        updateQuantityOfProduct(items);
    }

    private void updateQuantityOfProduct(List<Item> items) {
        for (int i = 0; i < items.size(); i++) {
            Product product = productService.getProductById(items.get(i).getProductId()).orElseThrow(ProductNotFoundException::new);
            product.setQuantity(product.getQuantity() - items.get(i).getQuantity());
            productService.saveProduct(product);
        }
    }

    public void addItemToCart(Long productId, Long cartId, int quantityToCart) throws CartNotFoundException, ProductNotFoundException {
        Product productById = productService.getProduct(productId);
        Item item = new Item(productId, productById.getName(), productById.getPrice(), quantityToCart);
        itemService.saveItem(item);
        cartRepository.findById(cartId).orElseThrow(CartNotFoundException::new).getItems().add(item);
    }

    public void deleteItemFromCart(Long itemId, Long cartId) throws CartNotFoundException, ItemNotFoundException {
        cartRepository.findById(cartId).orElseThrow(CartNotFoundException::new).
                getItems().remove(itemService.findItemById(itemId));
    }
}