package com.chronica.notification.data.constant;


import lombok.Getter;
import org.springframework.data.domain.Sort;

@Getter
public enum SortDirection {
    ASC("ASC", Sort.Direction.ASC),
    DESC("DESC", Sort.Direction.DESC);

    private final String name;
    private final Sort.Direction dir;
    SortDirection(String name, Sort.Direction dir) {
        this.name = name;
        this.dir = dir;
    }
}
