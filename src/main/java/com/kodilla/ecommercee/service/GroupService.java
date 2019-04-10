package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.groups.Group;
import com.kodilla.ecommercee.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GroupService {
    private GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Group saveGroup(final Group group) {
        return groupRepository.save(group);
    }

    public Optional<Group> getGroup(final Long id) {
        return groupRepository.findById(id);
    }
}
