package com.chronica.notification.data.dto;



public record PagingAndSortingDTO(String sortDirection,
                                  String sortField,
                                  Integer pageSize,
                                  Integer pageNumber) {
}
