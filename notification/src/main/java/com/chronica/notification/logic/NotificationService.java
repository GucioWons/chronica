package com.chronica.notification.logic;

import com.chronica.notification.data.entity.NotificationAbstractEntity;
import com.chronica.notification.data.repository.NotificationRepository;
import org.springframework.stereotype.Service;
@Service
public class NotificationService<Entity extends NotificationAbstractEntity>  {
    private final NotificationRepository<Entity> notificationRepository;

    public NotificationService(NotificationRepository<Entity> notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void save(Entity entity) {
        notificationRepository.save(entity);
    }
}
