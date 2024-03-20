package com.chronica.notification.data.constant;


import lombok.Getter;
import org.springframework.data.domain.Sort;

@Getter
public enum SortDirection {
    ASC(Sort.Direction.ASC),
    DESC(Sort.Direction.DESC);


    private final Sort.Direction dir;
    SortDirection(Sort.Direction dir) {

        this.dir = dir;
    }
}
