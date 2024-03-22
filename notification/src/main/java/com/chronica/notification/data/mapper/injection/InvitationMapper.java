package com.chronica.notification.data.mapper.injection;

import com.chronica.notification.data.dto.InvitationDTO;
import com.chronica.notification.data.dto.integrant.NotificationDTO;
import com.chronica.notification.data.entity.Invitation;
import com.chronica.notification.data.entity.Notification;
import com.chronica.notification.data.mapper.abstraction.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class InvitationMapper implements Mapper<InvitationDTO, Invitation> {

    private final NotificationMapper notificationMapper;

    public InvitationMapper(NotificationMapper notificationMapper) {
        this.notificationMapper = notificationMapper;
    }

    @Override
    public InvitationDTO mappToDto(Invitation invitation) {
        NotificationDTO notificationDTO = notificationMapper.mappToDto(invitation);

        InvitationDTO dto = new InvitationDTO();
        dto.setInvitationFromUserId(invitation.getInvitationFromUserId());
        dto.setAccepted(invitation.getAccepted());
        dto.setAcceptedAt(invitation.getAcceptedAt());
        dto.setGroupId(invitation.getGroupId());
        dto.setBaseData(notificationDTO);

        return dto;
    }

    @Override
    public Invitation mappToEntity(InvitationDTO invitationDTO) {
        Notification notification = notificationMapper.mappToEntity(invitationDTO.getBaseData());

        Invitation invitation = new Invitation();
        invitation.setNotification(notification);
        invitation.setInvitationFromUserId(invitationDTO.getInvitationFromUserId());
        invitation.setAccepted(invitationDTO.getAccepted());
        invitation.setAcceptedAt(invitationDTO.getAcceptedAt());
        invitation.setGroupId(invitationDTO.getGroupId());

        return invitation;
    }
}
