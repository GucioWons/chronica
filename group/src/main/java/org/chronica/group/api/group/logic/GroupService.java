package org.chronica.group.api.group.logic;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.chronica.group.api.group.entity.Group;
import org.chronica.group.api.group.repository.GroupRepository;

@ApplicationScoped
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;

    public Group getGroupById(Long id) {
        return groupRepository.findById(id);
    }

    @Transactional
    public Group createGroup(Group group) {
        group.persist();
        return group;
    }
}
