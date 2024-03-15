package com.chronica.notification.data.entity;

import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@RequiredArgsConstructor
@Data
public class Message extends Notification {
    private Long messageFromId;
}
