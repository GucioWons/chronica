package com.chronica.notification.logic.notification;

import com.chronica.notification.data.constant.NotificationType;
import com.chronica.notification.data.dto.NotificationDTO;
import com.chronica.notification.data.entity.Notification;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationSpecification<Entity extends Notification> {
    public Specification<Entity> findByCriteria(NotificationDTO filter) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.title() != null && !filter.title().isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("title")), "%" + filter.title().toLowerCase() + "%"));
            }
            if (filter.createdAt() != null) {
                predicates.add(cb.equal(root.get("createdAt"), filter.createdAt()));
            }
            if (filter.receiverId() != null) {
                predicates.add(cb.equal(root.get("receiverId"), filter.receiverId()));
            }
            if (filter.deprecated() != null) {
                predicates.add(cb.equal(root.get("deprecated"), filter.deprecated()));
            }

            if ((filter.notificationType() == NotificationType.MESSAGE)) {
                if (filter.messageFromId() != null) {
                    predicates.add(cb.equal(root.get("messageFromId"), filter.messageFromId()));
                }
            }

            if ((filter.notificationType() == NotificationType.INVITATION)) {
                if (filter.invitationFromId() != null) {
                    predicates.add(cb.equal(root.get("invitationFromId"), filter.invitationFromId()));
                }
            }

            if (filter.notificationType() == NotificationType.ALERT) {
                if (filter.priorityType() != null) {
                    predicates.add(cb.equal(root.get("priorityType"), filter.priorityType()));
                }
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
}
}