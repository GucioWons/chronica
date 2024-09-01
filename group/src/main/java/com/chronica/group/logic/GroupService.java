package com.chronica.group.logic;

import com.chronica.group.entity.Group;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import com.chronica.group.exception.NoGroupException;
import com.chronica.group.mapper.GroupMapper;
import com.chronica.group.repository.GroupRepository;
import org.chronica.library.dto.group.GroupDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    @Transactional
    public GroupDTO createGroup(GroupDTO toSave) {
        return groupMapper.mapToDTO(groupRepository.save(groupMapper.mapToNewEntity(toSave)));
    }

    public GroupDTO getGroupById(Long groupId) {
        return groupRepository.findByIdAndDeprecatedFalse(groupId)
                .map(groupMapper::mapToDTO)
                .orElseThrow(() -> new NoGroupException("Cannot find Group with id " + groupId));
    }

    public List<GroupDTO> getGroups() {
        return groupRepository
                .findAllByDeprecatedFalse()
                .stream()
                .map(groupMapper::mapToDTO)
                .toList();
    }

    @Transactional
    public GroupDTO updateGroup(Long groupId, GroupDTO toUpdate) {
        Group group = groupRepository
                .findByIdAndDeprecatedFalse(groupId)
                .map(entity -> groupMapper.mapToUpdateEntity(entity, toUpdate))
                .orElseThrow(() -> new NoGroupException("Cannot find Group with id " + groupId));
        return groupMapper.mapToDTO(groupRepository.save(group));
    }

    @Transactional
    public String deprecateGroup(Long groupId) {
        Group group = groupRepository
                .findByIdAndDeprecatedFalse(groupId)
                .orElseThrow(() -> new NoGroupException("Cannot find Group with id " + groupId));
        group.setDeprecated(true);
        groupRepository.save(group);
        return "Group has been deprecated.";
    }
}
