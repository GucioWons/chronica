package com.chronica.notification.data.constant;


import lombok.Getter;

@Getter
public enum SortDirection {
    ASC("ASC"),DESC("DESC");

    private final String name;

    SortDirection(String name) {
        this.name = name;
    }
}
