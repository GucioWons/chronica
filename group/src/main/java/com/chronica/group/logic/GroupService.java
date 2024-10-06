package com.chronica.group.logic;

import com.chronica.group.entity.Group;
import com.chronica.group.entity.GroupMember;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.chronica.library.exception.NoEntityException;
import com.chronica.group.mapper.GroupMapper;
import com.chronica.group.repository.GroupRepository;
import org.chronica.library.dto.group.GroupDTO;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    @Transactional
    public GroupDTO createGroup(GroupDTO toSave) {
        Group group = groupMapper.mapToNewEntity(toSave);
        Set<GroupMember> groupMembers = new HashSet<>();
        GroupMember groupMember = new GroupMember();
        groupMember.setUserId(toSave.getOwnerId());
        groupMembers.add(groupMember);
        group.setMembers(groupMembers);
        return groupMapper.mapToDTO(groupRepository.save(group));
    }

    public GroupDTO getGroupById(Long groupId) {
        return groupRepository.findByIdAndDeprecatedFalse(groupId)
                .map(groupMapper::mapToDTO)
                .orElseThrow(() -> new NoEntityException(Group.class.getSimpleName(), groupId));
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
                .orElseThrow(() -> new NoEntityException(Group.class.getSimpleName(), groupId));
        return groupMapper.mapToDTO(groupRepository.save(group));
    }

    @Transactional
    public String deprecateGroup(Long groupId) {
        Group group = groupRepository
                .findByIdAndDeprecatedFalse(groupId)
                .orElseThrow(() -> new NoEntityException(Group.class.getSimpleName(), groupId));
        group.setDeprecated(true);
        groupRepository.save(group);
        return "Group has been deprecated.";
    }
}
