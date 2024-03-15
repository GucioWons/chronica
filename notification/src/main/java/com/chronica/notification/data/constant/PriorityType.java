package com.chronica.notification.data.constant;

import lombok.Getter;

@Getter
public enum PriorityType {
    IMPORTANT(0), SPAM(1), DEFAULT(2);

    public final Integer id;
    PriorityType(Integer id){
        this.id = id;
    }
}
