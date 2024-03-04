package pl.gucio.enzo.chronica.user.domain.response;

import java.time.LocalDateTime;

public record CreateUserResponse(LocalDateTime createdAt, String message) {
}
