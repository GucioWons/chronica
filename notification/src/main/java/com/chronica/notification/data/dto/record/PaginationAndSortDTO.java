package com.chronica.notification.data.dto.record;

import org.springframework.data.domain.Sort;

public record PaginationAndSortDTO(Sort.Direction sortDirection,
                                   String sortField,
                                   Integer pageSize,
                                   Integer pageNumber) {
}
