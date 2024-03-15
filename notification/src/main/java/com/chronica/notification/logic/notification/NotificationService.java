package com.chronica.notification.logic.notification;

import com.chronica.notification.data.dto.NotificationDTO;
import com.chronica.notification.data.dto.PagingAndSortingDTO;
import com.chronica.notification.data.entity.Notification;
import com.chronica.notification.data.exception.NotificationDoesntExistException;
import com.chronica.notification.data.repository.NotificationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Page<Entity> findAll(NotificationDTO filter, PagingAndSortingDTO page){
        Sort.Direction drctn;

        if(page.sortDirection().equals("DESC"))
        {
            drctn = Sort.Direction.DESC;
        } else {
            drctn = Sort.Direction.ASC;
        }

        final Sort sortBy = Sort.by(drctn, page.sortField());
        final PageRequest pageProp = PageRequest.of(page.pageNumber(), page.pageSize(), sortBy);

        return notificationRepository.findAll(notificationSpecification.findByCriteria(filter), pageProp);
    }



}
