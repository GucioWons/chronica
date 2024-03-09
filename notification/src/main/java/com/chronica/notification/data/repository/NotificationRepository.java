package com.chronica.notification.data.repository;

import com.chronica.notification.data.entity.NotificationAbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


public interface NotificationRepository<Entity extends NotificationAbstractEntity> extends JpaRepository<Entity,Long> {
}
