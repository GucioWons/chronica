package com.chronica.notification.data.repository;

import com.chronica.notification.data.entity.Invitation;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface InvitationRepository extends NotificationRepository<Invitation> {
}
