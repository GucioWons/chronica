package org.chronica.group.api.group.logic;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.chronica.group.api.group.dto.GroupDTO;
import org.chronica.group.api.group.entity.Group;
import org.chronica.group.api.group.mapper.GroupMapper;
import org.chronica.group.api.group.repository.GroupRepository;

import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    @Transactional
    public GroupDTO createGroup(GroupDTO toSave) {
        Group group = groupMapper.mapToEntity(toSave);
        group.persist();
        return groupMapper.mapToDTO(group);
    }

    public GroupDTO getGroupById(Long id) {
        return groupRepository
                .findByIdOptional(id)
                .map(groupMapper::mapToDTO)
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<GroupDTO> getGroups() {
        return groupRepository
                .listAll()
                .stream()
                .map(groupMapper::mapToDTO)
                .toList();
    }

    @Transactional
    public GroupDTO updateGroup(Long groupId, GroupDTO toUpdate) {
        Group group = groupRepository
                .findByIdOptional(groupId)
                .map(entity -> groupMapper.mapToUpdateEntity(entity, toUpdate))
                .orElseThrow(IllegalArgumentException::new);
        group.persist();
        return groupMapper.mapToDTO(group);
    }
}
