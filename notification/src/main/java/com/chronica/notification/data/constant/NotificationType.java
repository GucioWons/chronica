package com.chronica.notification.data.constant;

import lombok.Getter;

@Getter
public enum NotificationType {
    MESSAGE(0),
    INVITATION(1),
    NEWSLETTER(2),
    ALERT(3);

    public final Integer id;

    NotificationType(Integer id) {
        this.id = id;
    }
}
