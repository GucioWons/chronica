package com.chronica.notification.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "INVITATIONS")
@RequiredArgsConstructor
@Setter
@Getter
public class Invitation extends Notification {
    private Long invitationFromId;
    private Boolean accepted;
    private LocalDateTime acceptedAt;
}
