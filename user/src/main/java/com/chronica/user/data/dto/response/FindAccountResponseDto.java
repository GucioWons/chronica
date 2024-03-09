package com.chronica.user.data.dto.response;

public record FindAccountResponseDto(String username,
                                     String mail,
                                     Long phoneNumber){
}
