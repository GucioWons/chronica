package org.chronica.library.enumerated;

import lombok.Getter;

@Getter
public enum AlertPriority {
    IMPORTANT(0),
    SPAM(1),
    DEFAULT(2);

    public final Integer id;
    AlertPriority(Integer id){
        this.id = id;
    }
}
