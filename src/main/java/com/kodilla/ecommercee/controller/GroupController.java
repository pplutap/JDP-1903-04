package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.groups.GroupDto;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/v1/group")
public class GroupController {
    private List<GroupDto> groups = Collections.emptyList();
    private List<ProductDto> products = Collections.emptyList();

    @GetMapping(value = "getGroups")
    public List<GroupDto> getGroups() {
        return groupDtos();
    }

    @PostMapping(value = "createGroup")
    public void createGroup(@RequestBody GroupDto groupDto) {
        groups.add(groupDto);
    }

    @GetMapping(value = "getGroup")
    public GroupDto getGroup(@RequestParam Long groupId) {
        groupDtos();
        for (GroupDto group : groups) {
            if (group.getGroupId().equals(groupId)) {
                return group;
            }
        }
        return null;
    }

    @PutMapping(value = "updateGroup")
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
        Long groupId = groupDto.getGroupId();
        for (GroupDto group : groups) {
            if (group.getGroupId().equals(groupId)) {
                group.setGroupName(groupDto.getGroupName());
                group.setProducts(groupDto.getProducts());
            }
        }
        return groupDto;
    }

    private List<GroupDto> groupDtos() {
        GroupDto groupDto1 = new GroupDto(1L, "groupNameTest1", products);
        GroupDto groupDto5 = new GroupDto(5L, "groupNameTest5", products);
        if (groups.isEmpty()) {
            groups.add(groupDto1);
            groups.add(groupDto5);
        }
        return groups;
    }
}
