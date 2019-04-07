package com.kodilla.ecommercee.domain.orders;

import com.kodilla.ecommercee.domain.groups.Group;
import com.kodilla.ecommercee.domain.products.Product;
import com.kodilla.ecommercee.repository.GroupRepository;

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
    private GroupRepository groupRepository;

    @Test
    public void shouldReturnNotNullGroupIdAndProductsId(){
        //Given
        Product huaweiP20 = new Product( "huawei p20 pro", "huawei is good phone", new BigDecimal(2300),
                false);
        Product samsungS8 = new Product("samsung S8", "samsung is good phone", new BigDecimal(1999),
                false);
        List<Product> smartphonesList = new ArrayList<>();
        smartphonesList.add(huaweiP20);
        smartphonesList.add(samsungS8);
        Group smartphones = new Group("smartphones",smartphonesList);
        huaweiP20.setGroup(smartphones);
        samsungS8.setGroup(smartphones);

        //when
        groupRepository.save(smartphones);
        //then
        Long samsungs8GroupId = samsungS8.getGroup().getGroupId();
        Long groupId = smartphones.getGroupId();
        Long huaweiP20productId = huaweiP20.getProductId();
        Long samsungS8ProductId = samsungS8.getProductId();

        assertNotEquals(null, groupId);
        assertNotEquals(null, huaweiP20productId);
        assertNotEquals(null, samsungS8ProductId);
        assertEquals(samsungs8GroupId, groupId);
        assertEquals(huaweiP20productId, smartphones.getProductsInGroup().get(0).getProductId());
        assertEquals(samsungS8ProductId, smartphones.getProductsInGroup().get(1).getProductId());
        assertEquals(2, smartphones.getProductsInGroup().size());
        //CleanUp
       groupRepository.delete(smartphones);
    }
}