package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.groups.Group;
import com.kodilla.ecommercee.domain.groups.GroupDto;
import com.kodilla.ecommercee.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupMapper {
    private ProductMapper productMapper;

    @Autowired
    public GroupMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public Group mapToGroup(final GroupDto groupDto) {
        return new Group(groupDto.getGroupName(), productMapper.mapToProductList(groupDto.getProductsInGroup()));
    }

    public GroupDto mapToGroupDto(final Group group) {
        return new GroupDto(group.getGroupId(), group.getGroupName(), productMapper.mapToProductDtoList(group.getProductsInGroup()));
    }

    public List<Group> mapToGroupDtoList(final List<GroupDto> groupDtoList) {
        return groupDtoList.stream()
                .map(groupDto -> new Group(groupDto.getGroupName(), productMapper.mapToProductList(groupDto.getProductsInGroup())))
                .collect(Collectors.toList());
    }

    public List<GroupDto> mapToGroupList(final List<Group> groupList) {
        return groupList.stream()
                .map(group -> new GroupDto(group.getGroupId(), group.getGroupName(),
                        productMapper.mapToProductDtoList(group.getProductsInGroup())))
                .collect(Collectors.toList());
    }
}