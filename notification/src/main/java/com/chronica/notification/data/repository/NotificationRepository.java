package com.chronica.notification.data.repository;

import com.chronica.notification.data.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface NotificationRepository<Entity extends Notification> extends JpaRepository<Entity,Long>, JpaSpecificationExecutor<Entity> {
}
