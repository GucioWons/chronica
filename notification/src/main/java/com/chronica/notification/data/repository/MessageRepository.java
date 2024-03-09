package com.chronica.notification.data.repository;

import com.chronica.notification.data.entity.Message;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends NotificationRepository<Message> {
}
