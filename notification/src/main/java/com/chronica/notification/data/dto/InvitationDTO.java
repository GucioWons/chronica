package com.chronica.notification.data.dto;

import com.chronica.notification.data.dto.abstraction.NotificationDTO;
import com.chronica.notification.data.dto.integrant.BaseDataDTO;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvitationDTO extends NotificationDTO {
    private Long inviterId;
    private Boolean accepted;
    private LocalDateTime acceptedAt;
    private Long groupId;
    private BaseDataDTO baseData;
}
