package com.chronica.user.data.mapper;

import org.chronica.library.user.dto.LinkConfirmationDTO;
import org.mapstruct.Mapper;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface LinkConfirmationMapper {
    LinkConfirmationDTO mapToDTO(String mail, boolean isActivated, LocalDateTime confirmedAt);
}
