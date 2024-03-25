package com.chronica.notification.data.constant;

import lombok.Getter;

@Getter
public enum Priority {
    IMPORTANT(0),
    SPAM(1),
    DEFAULT(2);

    public final Integer id;
    Priority(Integer id){
        this.id = id;
    }
}
