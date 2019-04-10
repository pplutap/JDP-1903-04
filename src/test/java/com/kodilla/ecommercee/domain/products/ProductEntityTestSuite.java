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

    private Product lapDell = new Product(
            "Dell Latitude 5480",
            "i7-7820HQ 16GB 256SSD FHD 10Pro",
            new BigDecimal(4590));
    private Product appleAir = new Product(
            "Apple Macbook Air",
            "13' i5 8GB 256GB MREF2ZE/A 2018",
            new BigDecimal(5999));
    private Product asusVivo = new Product(
            "ASUS VivoBook 15 R564UA",
            "i5-8250U 8GB 256SSD MAT",
            new BigDecimal(2599));
    private List<Product> laptops = new ArrayList<>();
    private Group groupOfLaptops = new Group("Laptops", laptops);

    private Product p1 = new Product("a", "da", new BigDecimal(1));
    private Product p2 = new Product("b", "db", new BigDecimal(1));
    private Product p3 = new Product("c", "dc", new BigDecimal(1));
    private Product p4 = new Product("d", "de", new BigDecimal(1));
    private Product p5 = new Product("e", "df", new BigDecimal(1));

    private Cart c1 = new Cart();
    private Cart c2 = new Cart();
    private Cart c3 = new Cart();

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

    @Test
    public void shouldSaveProductsWithoutDuplicates() {
        //Given
        c1.setProducts(Arrays.asList(p3, p4, p5));
        c2.setProducts(Arrays.asList(p1, p2, p3));
        c3.setProducts(Arrays.asList(p1, p3, p4, p5));

        p1.setCarts(Arrays.asList(c2, c3));
        p2.setCarts(Arrays.asList(c2));
        p3.setCarts(Arrays.asList(c1, c2, c3));
        p4.setCarts(Arrays.asList(c1, c3));
        p5.setCarts(Arrays.asList(c1, c3));

        //When
        cartRepository.save(c1);
        cartRepository.save(c2);
        cartRepository.save(c3);
        List<Product> products = productRepository.findAll();
        HashSet<Product> set = new HashSet<>(products);

        //Then
        Assert.assertEquals(5, products.size());
        Assert.assertEquals(5, set.size());
    }

    @Test
    public void shouldReturnEmptyListOfCarts(){
        //Given
        List<Product> fakeProductsList = null;
        List<Cart> fakeCartsList = null;

        asusVivo.setCarts(fakeCartsList);
        c1.setProducts(fakeProductsList);

        //When
        productRepository.save(asusVivo);
        List<Cart> carts = cartRepository.findAll();

        //Then
        Assert.assertTrue(carts.isEmpty());
    }

    @After
    public void cleanUp() {
        //CleanUp
        try {
            productRepository.delete(lapDell);
            productRepository.delete(appleAir);
            productRepository.delete(asusVivo);
            productRepository.delete(p1);
            productRepository.delete(p2);
            productRepository.delete(p3);
            productRepository.delete(p4);
            productRepository.delete(p5);

            cartRepository.delete(c1);
            cartRepository.delete(c2);
            cartRepository.delete(c3);

            groupRepository.delete(groupOfLaptops);

        } catch (Exception e) {
            //do nothing
        }
    }
}