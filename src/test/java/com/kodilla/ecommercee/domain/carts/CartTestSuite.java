package com.kodilla.ecommercee.domain.carts;

import com.kodilla.ecommercee.domain.products.Product;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartTestSuite {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;

    public void deleteAllDummyData(Cart cart, Product product) {

        try {
            cartRepository.delete(cart);
            productRepository.delete(product);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testAddingRowToTheCartEntity() {
        //    Given
        Cart cart = new Cart();
        int openingCartEntitySize = cartRepository.findAll().size();

        //    When
        cartRepository.save(cart);
        Long cartId = cart.getCartId();
        List<Cart> carts = cartRepository.findAll();

        //    Then
        assertEquals(openingCartEntitySize + 1, carts.size());
        assertEquals(carts.get(openingCartEntitySize).getCartId(), cartId);

        //    Cleanup
        deleteAllDummyData(cart, null);
    }

    @Test
    public void testAddNullObject() {
        //    Given
        Cart cart = new Cart();
        cart.setItems(null);
        int openingCartEntitySize = cartRepository.findAll().size();
        //    When+
        cartRepository.save(cart);
        List<Cart> carts = cartRepository.findAll();
        //    Then
        assertEquals(openingCartEntitySize + 1, carts.size());
        //    Cleanup
        deleteAllDummyData(cart, null);
    }
}