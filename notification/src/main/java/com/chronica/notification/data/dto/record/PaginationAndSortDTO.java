package com.chronica.notification.data.dto.record;

import com.chronica.notification.data.constant.SortDirection;

public record PaginationAndSortDTO(SortDirection sortDirection,
                                   String sortField,
                                   Integer pageSize,
                                   Integer pageNumber) {
}
