package com.kodilla.ecommercee.domain.products;

import com.kodilla.ecommercee.domain.carts.Cart;
import com.kodilla.ecommercee.domain.groups.Group;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductEntityTestSuite {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private CartRepository cartRepository;

    private Product lapDell = new Product.ProductBuilder()
            .name("Dell Latitude 5480")
            .description("i7-7820HQ 16GB 256SSD FHD 10Pro")
            .price(new BigDecimal(4590))
            .quantity(10)
            .build();

    private Product appleAir = new Product.ProductBuilder()
            .name("Apple Macbook Air")
            .description("13' i5 8GB 256GB MREF2ZE/A 2018")
            .price(new BigDecimal(5590))
            .quantity(10)
            .build();


    private Product asusVivo = new Product.ProductBuilder()
            .name("ASUS VivoBook 15 R564UA")
            .description("i5-8250U 8GB 256SSD MAT")
            .price(new BigDecimal(2590))
            .quantity(10)
            .build();

    private List<Product> laptops = new ArrayList<>();
    private Group groupOfLaptops = new Group("Laptops", laptops);

    @Test
    public void shouldSaveProductsInDB() {
        //Given

        //When
        List<Product> oldList = (List<Product>) productRepository.findAll();
        productRepository.save(lapDell);
        productRepository.save(appleAir);
        List<Product> newList = (List<Product>) productRepository.findAll();
        Long firstId = lapDell.getProductId();
        Long secondId = appleAir.getProductId();

        //Then
        Assert.assertEquals(2, newList.size() - oldList.size());
        Assert.assertNotEquals(firstId, secondId);
    }

    @Test
    public void shouldSaveProductInDBCauseRelation() {
        //Given
        laptops.add(asusVivo);

        //When
        groupRepository.save(groupOfLaptops);
        Long productId = asusVivo.getProductId();

        //Then
        Assert.assertNotNull(productId);
    }

    @Test
    public void shouldSaveNoProducts() {
        //Given
        laptops = null;
        groupOfLaptops.setProductsInGroup(laptops);

        //when
        groupRepository.save(groupOfLaptops);
        List<Product> products = productRepository.findAll();

        //Then
        Assert.assertTrue(products.isEmpty());
    }




    @After
    public void cleanUp() {
        //CleanUp
        try {
            productRepository.delete(lapDell);
            productRepository.delete(appleAir);
            productRepository.delete(asusVivo);

            groupRepository.delete(groupOfLaptops);

        } catch (Exception e) {
            //do nothing
        }
    }
}