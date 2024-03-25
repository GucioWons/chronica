package com.chronica.notification.data.dto;

import com.chronica.notification.data.dto.abstraction.BaseDTO;
import com.chronica.notification.data.dto.integrant.NotificationDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO extends BaseDTO {
    private Long messageFromUserId;
    private NotificationDTO baseData;
}
