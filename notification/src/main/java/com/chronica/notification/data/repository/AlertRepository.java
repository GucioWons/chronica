package com.chronica.notification.data.repository;

import com.chronica.notification.data.entity.Alert;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertRepository extends NotificationRepository<Alert> {
}
