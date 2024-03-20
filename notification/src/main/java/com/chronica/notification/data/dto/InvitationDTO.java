package com.chronica.notification.data.dto;

import com.chronica.notification.data.dto.abstraction.BaseDTO;
import com.chronica.notification.data.dto.integrant.NotificationDTO;
import lombok.*;

import java.time.LocalDateTime;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvitationDTO extends BaseDTO {
    private Long invitationFromUserId;
    private Boolean accepted;
    private LocalDateTime acceptedAt;
    private Long groupId;
    private NotificationDTO baseData;
}
