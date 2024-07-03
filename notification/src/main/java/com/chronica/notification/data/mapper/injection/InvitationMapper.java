package com.chronica.notification.data.mapper.injection;

import org.chronica.library.commons.exception.NotImplementedException;
import org.chronica.library.commons.mapper.BaseMapper;
import org.chronica.library.notification.dto.InvitationDTO;
import com.chronica.notification.data.entity.Invitation;
import org.springframework.stereotype.Component;

@Component
public class InvitationMapper implements BaseMapper<Invitation, InvitationDTO> {

    private final NotificationMapper notificationMapper;

    public InvitationMapper(NotificationMapper notificationMapper) {
        this.notificationMapper = notificationMapper;
    }

    @Override
    public InvitationDTO mapToDTO(Invitation invitation) {
        InvitationDTO dto = new InvitationDTO();
        notificationMapper.mapToDTO(dto,invitation);
        dto.setInviterId(invitation.getInviterId());
        dto.setAccepted(invitation.getAccepted());
        dto.setAcceptedAt(invitation.getAcceptedAt());
        dto.setGroupId(invitation.getGroupId());
        return dto;
    }

    @Override
    public Invitation mapToNewEntity(InvitationDTO dto) {
        Invitation invitation = new Invitation();
        notificationMapper.mapToNewEntity(invitation,dto);
        invitation.setInviterId(dto.getInviterId());
        invitation.setAccepted(dto.getAccepted());
        invitation.setAcceptedAt(dto.getAcceptedAt());
        invitation.setGroupId(dto.getGroupId());
        return invitation;
    }

    @Override
    public Invitation mapToUpdateEntity(Invitation toUpdate, InvitationDTO dto) {
        throw new NotImplementedException();
    }
}
