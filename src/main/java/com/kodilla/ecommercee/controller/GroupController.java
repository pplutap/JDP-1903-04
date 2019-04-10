package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.controller.exceptions.GroupNotFoundException;
import com.kodilla.ecommercee.domain.groups.GroupDto;
import com.kodilla.ecommercee.domain.products.ProductDto;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/group")
public class GroupController {
    private GroupService groupService;
    private GroupMapper groupMapper;

    @Autowired
    public GroupController(GroupService groupService, GroupMapper groupMapper) {
        this.groupService = groupService;
        this.groupMapper = groupMapper;
    }

    @GetMapping(value = "getGroups")
    public List<GroupDto> getGroups() {
        return groupMapper.mapToGroupList(groupService.getAllGroups());
    }

    @PostMapping(value = "createGroup")
    public void createGroup(@RequestBody GroupDto groupDto) {
        groupService.saveGroup(groupMapper.mapToGroup(groupDto));
    }

    @GetMapping(value = "getGroup")
    public GroupDto getGroup(@RequestParam Long groupId) throws GroupNotFoundException {
        return groupMapper.mapToGroupDto(groupService.getGroup(groupId).orElseThrow(GroupNotFoundException::new));
    }

    @PutMapping(value = "updateGroup")
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
        return groupMapper.mapToGroupDto(groupService.saveGroup(groupMapper.mapToGroup(groupDto)));
    }
}
