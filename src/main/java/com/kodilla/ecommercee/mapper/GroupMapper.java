package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.groups.Group;
import com.kodilla.ecommercee.domain.groups.GroupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GroupMapper {
    private ProductMapper productMapper;

    @Autowired
    public GroupMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public Group mapToGroup(final GroupDto groupDto){
        return new Group(groupDto.getGroupName(),productMapper.mapToProductList(groupDto.getProductsInGroup()));
    }

    public GroupDto mapToGroupDto(final Group group){
        return new GroupDto(group.getGroupId(),group.getGroupName(),productMapper.mapToProductDtoList(group.getProductsInGroup()));
    }
}