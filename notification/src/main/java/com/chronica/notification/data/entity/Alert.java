package com.chronica.notification.data.entity;

import com.chronica.notification.data.constant.Priority;
import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@RequiredArgsConstructor
@Data
public class Alert extends Notification {
    private Priority priority;

}
