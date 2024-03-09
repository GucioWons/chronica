package com.chronica.notification.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "INVITATIONS")
@RequiredArgsConstructor
@Setter
@Getter
public class Invitation extends NotificationAbstractEntity {
    private Long broadcasterId;
    private Boolean accepted;
    private LocalDateTime acceptedAt;
}
