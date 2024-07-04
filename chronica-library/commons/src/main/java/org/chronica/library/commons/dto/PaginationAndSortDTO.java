package org.chronica.library.commons.dto;

import org.springframework.data.domain.Sort;

public record PaginationAndSortDTO(Sort.Direction sortDirection,
                                   String sortField,
                                   Integer pageSize,
                                   Integer pageNumber) {
}
