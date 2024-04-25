package com.chronica.user.data.mapper;

import com.chronica.user.data.dto.LinkConfirmationDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class LinkConfirmationMapper {
    public LinkConfirmationDTO mapToDTO(String mail, boolean isActivated, LocalDateTime confirmedAt) {
        return new LinkConfirmationDTO(
                mail,
                isActivated,
                confirmedAt);
    }
}
