package com.chronica.notification.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "MESSAGES")
@RequiredArgsConstructor
@Setter
@Getter
public class Message extends NotificationAbstractEntity {
    private Long broadcasterId;
}
