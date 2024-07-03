package org.chronica.library.notification.dto;

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
