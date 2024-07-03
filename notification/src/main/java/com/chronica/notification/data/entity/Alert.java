package com.chronica.notification.data.entity;

import org.chronica.library.notification.enumerated.Priority;
import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@RequiredArgsConstructor
@Data
public class Alert extends Notification {
    private Priority priority;
}
