package com.chronica.notification.data.entity;

import com.chronica.notification.data.constant.PriorityType;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@RequiredArgsConstructor
@Data
public class Alert extends Notification {
private PriorityType priorityType = PriorityType.Default;
}
