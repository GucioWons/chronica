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

            addPredicateIfNotNull(predicates, filter.title(), "title", root, cb, true);
            addPredicateIfNotNull(predicates, filter.content(), "content", root, cb, false);
            addPredicateIfNotNull(predicates, filter.createdAt(), "createdAt", root, cb, false);
            addPredicateIfNotNull(predicates, filter.receiverId(), "receiverId", root, cb, false);
            addPredicateIfNotNull(predicates, filter.deprecated(), "deprecated", root, cb, false);
            addPredicateIfNotNull(predicates, filter.notificationType(), "notificationType", root, cb, false);
            addPredicateIfNotNull(predicates, filter.messageFromId(), "messageFromId", root, cb, false);
            addPredicateIfNotNull(predicates, filter.invitationFromId(), "invitationFromId", root, cb, false);
            addPredicateIfNotNull(predicates, filter.priorityType(), "priorityType", root, cb, false);

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

    private void addPredicateIfNotNull(List<Predicate> predicates, Object value, String fieldName, Root<Entity> root, CriteriaBuilder cb, boolean isLike) {
        if (value != null) {
            if (value instanceof String && isLike && !((String) value).isBlank()) {
                predicates.add(cb.like(cb.lower(root.get(fieldName)), "%" + ((String) value).toLowerCase() + "%"));
            } else if (!(value instanceof String) || !((String) value).isBlank()) {
                predicates.add(cb.equal(root.get(fieldName), value));
            }
        }
    }
}