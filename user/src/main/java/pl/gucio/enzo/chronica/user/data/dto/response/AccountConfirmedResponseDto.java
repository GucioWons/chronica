package pl.gucio.enzo.chronica.user.data.dto.response;

import java.time.LocalDateTime;

public record AccountConfirmedResponseDto(String mail,Boolean isActivated, LocalDateTime confirmedAt) {
}