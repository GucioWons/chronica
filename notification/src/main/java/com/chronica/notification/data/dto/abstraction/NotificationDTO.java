package com.chronica.notification.data.dto.abstraction;


import com.chronica.notification.data.constant.NotificationType;
import com.chronica.notification.data.dto.AlertDTO;
import com.chronica.notification.data.dto.InvitationDTO;
import com.chronica.notification.data.dto.MessageDTO;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AlertDTO.class, name = "alert"),
        @JsonSubTypes.Type(value = InvitationDTO.class, name = "invitation"),
        @JsonSubTypes.Type(value = MessageDTO.class, name = "message")
})
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class NotificationDTO {
    private NotificationType notificationType;
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime viewAt;
    private Long receiverId;
    private Boolean deprecated;
    private Boolean seen;
}
