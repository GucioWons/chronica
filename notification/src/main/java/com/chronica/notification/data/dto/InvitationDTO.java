package com.chronica.notification.data.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Value
public class InvitationDTO extends NotificationDTO{
    Long invitationFromUserId;
    Boolean accepted;
    LocalDateTime acceptedAt;
    Long groupId;
}
