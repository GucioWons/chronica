package com.chronica.notification.logic.notification;

import com.chronica.notification.data.dto.NotificationDTO;
import com.chronica.notification.data.dto.PaginationAndSortDTO;
import com.chronica.notification.data.entity.Notification;
import com.chronica.notification.data.exception.NotificationDoesntExistException;
import com.chronica.notification.data.repository.NotificationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class NotificationService<Entity extends Notification>  {
    private final NotificationRepository<Entity> notificationRepository;
    private final NotificationSpecification<Entity> notificationSpecification;

    public NotificationService(NotificationRepository<Entity> notificationRepository, NotificationSpecification notificationSpecification) {
        this.notificationRepository = notificationRepository;
        this.notificationSpecification = notificationSpecification;
    }

    public void save(Entity entity) {
        notificationRepository.save(entity);
    }

    public Notification findById(Long id){
        return notificationRepository.findById(id)
                .orElseThrow(() -> new NotificationDoesntExistException("Notification not found"));
    }

    public Page<Entity> findAll(NotificationDTO filter, PaginationAndSortDTO page){
        Sort sortBy = Sort.by(page.sortDirection().getDir(), page.sortField());
        PageRequest pageProp = PageRequest.of(page.pageNumber(), page.pageSize(), sortBy);

        return notificationRepository.findAll(notificationSpecification.findByCriteria(filter), pageProp);
    }



}
