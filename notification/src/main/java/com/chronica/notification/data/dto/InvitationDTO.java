package com.chronica.notification.data.dto;

import com.chronica.notification.data.dto.abstraction.NotificationDTO;
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
}
