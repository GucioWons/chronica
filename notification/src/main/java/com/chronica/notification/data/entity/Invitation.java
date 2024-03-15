package com.chronica.notification.data.entity;

import jakarta.persistence.Entity;
import lombok.*;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@RequiredArgsConstructor
@Data
public class Invitation extends Notification {
    private Long userFromId;
    private Boolean accepted;
    private LocalDateTime acceptedAt;
}
