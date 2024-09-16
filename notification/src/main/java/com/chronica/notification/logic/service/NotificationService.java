package com.chronica.notification.logic.service;

import org.chronica.library.commons.dto.PaginationAndSortDTO;
import com.chronica.notification.data.entity.Notification;
import org.chronica.library.exception.notification.NoNotificationException;
import com.chronica.notification.data.repository.NotificationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService<Entity extends Notification>  {
    private final NotificationRepository<Entity> notificationRepository;

    public NotificationService(NotificationRepository<Entity> notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void save(Entity entity) {
        notificationRepository.save(entity);
    }

    public Notification findById(Long id){
        return notificationRepository.findById(id)
                .orElseThrow(() -> new NoNotificationException("Notification not found"));
    }

    public List<Entity> findAll(){
        return notificationRepository.findAll();
    }

}
