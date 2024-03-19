package com.chronica.notification.data.dto;



import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;


@EqualsAndHashCode(callSuper = true)
@Data
public class InvitationDTO extends NotificationDTO{
    private Long invitationFromUserId;
    private Boolean accepted;
    private LocalDateTime acceptedAt;
    private Long groupId;
}
