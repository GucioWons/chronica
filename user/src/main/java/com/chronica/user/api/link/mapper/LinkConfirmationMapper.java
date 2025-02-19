package com.chronica.user.api.link.mapper;

import org.chronica.library.dto.user.LinkConfirmationDTO;
import org.mapstruct.Mapper;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface LinkConfirmationMapper {
    LinkConfirmationDTO mapToDTO(String mail, boolean isActivated, LocalDateTime confirmedAt);
}
