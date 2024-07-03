package org.chronica.library.notification.dto.record;

import org.springframework.data.domain.Sort;

public record PaginationAndSortDTO(Sort.Direction sortDirection,
                                   String sortField,
                                   Integer pageSize,
                                   Integer pageNumber) {
}
