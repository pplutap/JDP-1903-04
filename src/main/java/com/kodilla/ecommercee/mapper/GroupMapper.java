package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.GroupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GroupMapper {

    @Autowired
    ProductMapper productMapper;

    public Group mapToGroup(final GroupDto groupDto){
        return new Group(groupDto.getGroupId(), groupDto.getGroupName(),productMapper.mapToProductList(groupDto.getProductsInGroup()));
    }

    public GroupDto mapToGroupDto(final Group group){
        return new GroupDto(group.getGroupId(),group.getGroupName(),productMapper.mapToProductDtoList(group.getProductsInGroup()));
    }
}
