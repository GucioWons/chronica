package com.chronica.notification.data.dto;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.chronica.library.dto.EntityDTO;

import java.time.LocalDateTime;


@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
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
public class NotificationDTO extends EntityDTO {
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime viewAt;
    private Long receiverId;
    private Boolean deprecated;
    private Boolean seen;
}
