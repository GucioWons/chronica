package com.chronica.group.logic;

import com.chronica.group.entity.Group;
import com.chronica.group.entity.GroupInvitation;
import com.chronica.group.entity.GroupMember;
import com.chronica.group.mapper.GroupMapper;
import com.chronica.group.mapper.GroupMemberMapper;
import com.chronica.group.repository.GroupMemberRepository;
import jakarta.transaction.Transactional;
import org.chronica.library.client.UserClient;
import com.chronica.group.mapper.GroupInvitationMapper;
import com.chronica.group.repository.GroupInvitationRepository;
import com.chronica.group.repository.GroupRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.chronica.library.dto.group.GroupDTO;
import org.chronica.library.dto.group.GroupInvitationDTO;
import org.chronica.library.dto.group.GroupMemberDTO;
import org.chronica.library.dto.user.AccountDTO;
import org.chronica.library.enumerated.InvitationStatus;
import org.chronica.library.exception.ChronicaException;
import org.chronica.library.exception.dto.enumerated.ErrorMessage;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroupMembershipService {
    private final GroupInvitationRepository groupInvitationRepository;
    private final GroupInvitationMapper groupInvitationMapper;
    private final GroupMemberMapper groupMemberMapper;
    private final GroupMapper groupMapper;
    private final GroupMemberRepository groupMemberRepository;
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


        return groupInvitationMapper.mapToDTO(groupInvitation);
    }


    public Set<GroupDTO> getMemberGroups(Long userId) {
        return groupMemberRepository.findGroupMemberByUserMemberId(userId)
                .get().getGroups().stream().map(groupMapper::mapToDTO)
                .collect(Collectors.toSet());
    }
}
