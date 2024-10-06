package com.chronica.group.logic;

import com.chronica.group.entity.Group;
import com.chronica.group.entity.GroupInvitation;
import org.chronica.library.client.UserClient;
import com.chronica.group.mapper.GroupInvitationMapper;
import com.chronica.group.repository.GroupInvitationRepository;
import com.chronica.group.repository.GroupRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.chronica.library.dto.group.GroupInvitationDTO;
import org.chronica.library.dto.user.AccountDTO;
import org.chronica.library.enumerated.InvitationStatus;
import org.chronica.library.exception.ChronicaException;
import org.chronica.library.exception.dto.enumerated.ErrorMessage;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupInvitationService {
    private final GroupInvitationRepository groupInvitationRepository;
    private final GroupInvitationMapper groupInvitationMapper;
    private final GroupRepository groupRepository;
    private final UserClient userClient;

    public GroupInvitationDTO sendInvitationToGroup(GroupInvitationDTO request, Long groupId, HttpServletRequest req){
        AccountDTO account = userClient.getAccount(request.getInvitedUserId(), req);

        if(account == null){
            throw new ChronicaException(ErrorMessage.NO_ENTITY_EXCEPTION);
        }

        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new ChronicaException(ErrorMessage.NO_ENTITY_EXCEPTION));

        GroupInvitation groupInvitation = groupInvitationMapper.mapToNewEntity(request);
        groupInvitation.setInvitationStatus(InvitationStatus.AWAITED);
        groupInvitation.setGroup(group);

        return groupInvitationMapper.mapToDTO(groupInvitationRepository.save(groupInvitation));
    }
}
