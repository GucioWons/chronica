package com.chronica.notification.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Table(name = "MESSAGES")
@RequiredArgsConstructor
@Setter
@Getter
public class Message extends Notification {
    private Long messageFromId;
}
