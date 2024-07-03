package com.chronica.notification.logic.notification;

import org.chronica.library.dto.PaginationAndSortDTO;
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

    public NotificationService(NotificationRepository<Entity> notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void save(Entity entity) {
        notificationRepository.save(entity);
    }

    public Notification findById(Long id){
        return notificationRepository.findById(id)
                .orElseThrow(() -> new NotificationDoesntExistException("Notification not found"));
    }

    public Page<Entity> findAll(PaginationAndSortDTO page){
        Sort sortBy = Sort.by(page.sortDirection(), page.sortField());
        PageRequest pageProp = PageRequest.of(page.pageNumber(), page.pageSize(), sortBy);

        return notificationRepository.findAll(pageProp);
    }

}
