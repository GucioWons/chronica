package com.chronica.notification.logic.notification;

import com.chronica.notification.data.entity.Alert;
import com.chronica.notification.data.entity.Invitation;
import com.chronica.notification.data.entity.Message;
import com.chronica.notification.data.repository.AlertRepository;
import com.chronica.notification.data.repository.InvitationRepository;
import com.chronica.notification.data.repository.MessageRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationServiceConfig {

    @Bean
    public NotificationService<Message> messageService(MessageRepository messageRepository, NotificationSpecification notificationSpecification) {
        return new NotificationService<>(messageRepository,notificationSpecification);
    }

    @Bean
    public NotificationService<Invitation> invitationService(InvitationRepository invitationRepository, NotificationSpecification notificationSpecification) {
        return new NotificationService<>(invitationRepository,notificationSpecification);
    }

    @Bean
    public NotificationService<Alert> alertService(AlertRepository alertRepository, NotificationSpecification notificationSpecification) {
        return new NotificationService<>(alertRepository,notificationSpecification);
    }
}
