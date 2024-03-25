package com.chronica.notification.data.dto;

import com.chronica.notification.data.dto.abstraction.NotificationDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO extends NotificationDTO {
    private Long messageFromUserId;
}
