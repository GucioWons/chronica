package com.chronica.notification.data.dto;


import com.chronica.notification.data.constant.SortDirection;

public record PagingAndSortingDTO(SortDirection sortDirection,
                                  String sortField,
                                  Integer pageSize,
                                  Integer pageNumber) {
}
