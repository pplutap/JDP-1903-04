package com.kodilla.ecommercee.domain.carts;

import com.kodilla.ecommercee.domain.products.Product;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartTestSuite {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testAddingRowToTheCartEntity() {
//    Given
        Cart cart = new Cart();

//    When
        cartRepository.save(cart);
        Long cartId = cart.getCartId();
        List<Cart> carts = (List<Cart>) cartRepository.findAll();

//    Then
        assertEquals(1, carts.size());
        assertEquals(carts.get(0).getCartId(), cartId);

//    ClenUp
        try {
            cartRepository.delete(cart);
        } catch (Exception e) {
//          do nothing
        }
    }


    @Test
    public void testRelationCartProduct() {
//    Given
        Product product = new Product("Zapałki","10 boxes with 20 matches", new BigDecimal(2),false);
        Cart cart = new Cart();
//    When
        cart.getProducts().add(product);
        cartRepository.save(cart);
        long productId = product.getProductId();
        long cartId = cart.getCartId();

        List<Product> products = (List<Product>)productRepository.findAll();

//    Then
        assertNotEquals(0L, cartId );
        assertNotEquals(0L, productId);
        assertEquals(1, products.size());

//    Cleanup
        try {
            cartRepository.delete(cart);
            productRepository.delete(product);
        } catch (Exception e) {
//            do nothing
        }
    }
}