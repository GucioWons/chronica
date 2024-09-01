package com.chronica.notification.data.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.chronica.library.enumerated.AlertPriority;

@EqualsAndHashCode(callSuper = true)
@Entity
@RequiredArgsConstructor
@Data
public class Alert extends Notification {
    private AlertPriority alertPriority;
}
