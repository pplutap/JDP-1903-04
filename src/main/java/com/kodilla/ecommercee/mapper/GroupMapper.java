package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.groups.Group;
import com.kodilla.ecommercee.domain.groups.GroupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GroupMapper {

    @Autowired
    ProductMapper productMapper;

    public Group groupDtoToGroup(final GroupDto groupDto){
        return new Group(groupDto.getGroupId(), groupDto.getGroupName(), productMapper.productDtoListToProductList(groupDto.getProducts()));
    }

    public GroupDto groupToGroupDto(final Group group){
        return new GroupDto(group.getGroupId(), group.getGroupName(), productMapper.productListToProductDtoList(group.getProductsInGroup()));
    }
}
