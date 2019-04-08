package com.kodilla.ecommercee.domain.groups;

import com.kodilla.ecommercee.domain.products.Product;
import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupEntityTestSuite {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private ProductRepository productRepository;


    Group smartphonesGroup = new Group("smartphonesGroup", new ArrayList<>());

    @After
    public void cleanUp() {
        try {
            groupRepository.delete(smartphonesGroup);
        } catch (Exception e) {
        }
    }

    @Test
    public void shouldReturnNotNullGroupIdAndProductIds() {
        //Given
        Product huaweiP20 = new Product("huawei p20 pro", "huawei is good phone", new BigDecimal(2300),
                false);
        Product samsungS8 = new Product("samsung S8", "samsung is good phone", new BigDecimal(1999),
                false);
        List<Product> smartphones = new ArrayList<>();
        smartphones.add(huaweiP20);
        smartphones.add(samsungS8);
        smartphonesGroup.setProductsInGroup(smartphones);
        huaweiP20.setGroup(smartphonesGroup);
        samsungS8.setGroup(smartphonesGroup);


        //when
        groupRepository.save(smartphonesGroup);

        //then
        Long samsungs8GroupId = samsungS8.getGroup().getGroupId();
        Long groupId = smartphonesGroup.getGroupId();
        Long huaweiP20productId = huaweiP20.getProductId();
        Long samsungS8ProductId = samsungS8.getProductId();

        assertNotEquals(null, groupId);
        assertNotEquals(null, huaweiP20productId);
        assertNotEquals(null, samsungS8ProductId);
        assertEquals(samsungs8GroupId, groupId);
        assertEquals(huaweiP20productId, smartphonesGroup.getProductsInGroup().get(0).getProductId());
        assertEquals(samsungS8ProductId, smartphonesGroup.getProductsInGroup().get(1).getProductId());
        assertEquals(productRepository.count(), smartphonesGroup.getProductsInGroup().size());
    }

    @Test
    public void shouldReturnNotNullGroupIdAndSamsung8GroupId() {
        //given
        Product huaweiP20 = null;
        Product samsungS8 = new Product("samsung S8", "samsung is good phone", new BigDecimal(1999),
                false);
        List<Product> smartphones = new ArrayList<>();
        smartphones.add(huaweiP20);
        smartphones.add(samsungS8);
        smartphonesGroup.setProductsInGroup(smartphones);
        samsungS8.setGroup(smartphonesGroup);
        //when
        groupRepository.save(smartphonesGroup);
        Long samsungs8GroupId = samsungS8.getGroup().getGroupId();
        Long groupId = smartphonesGroup.getGroupId();
        Long samsungS8ProductId = samsungS8.getProductId();

        assertNotEquals(null, groupId);
        assertNotEquals(null, samsungS8ProductId);
        assertEquals(samsungs8GroupId, groupId);
        assertEquals(samsungS8ProductId, smartphonesGroup.getProductsInGroup().get(1).getProductId());
        assertEquals(1, productRepository.count());
    }

    @Test
    public void shouldReturnNotNullGroupIdAndEmptyListOfProduct() {
        //Given
        List<Product> emptyList = new ArrayList<>();
        smartphonesGroup.setProductsInGroup(emptyList);
        //when
        groupRepository.save(smartphonesGroup);
        //then
        Long groupId = smartphonesGroup.getGroupId();
        assertNotEquals(null, groupId);
        assertEquals(productRepository.count(), smartphonesGroup.getProductsInGroup().size());
    }

    @Test
    public void shouldReturnNotNullGroupIdAndNullAsListOfProduct() {
        //Given
        Group smartphonesGroup = new Group("smartphonesGroup", null);
        //when
        groupRepository.save(smartphonesGroup);
        //then
        Long groupId = smartphonesGroup.getGroupId();
        assertNotEquals(null, groupId);
        assertEquals(null, smartphonesGroup.getProductsInGroup());
    }
}