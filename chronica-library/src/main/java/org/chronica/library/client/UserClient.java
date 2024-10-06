package org.chronica.library.client;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.chronica.library.dto.user.AccountDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class UserClient {
    private static final String USER_MODULE_URL = "http://Chronica-user-module/api/accounts/{id}";
    private final WebClient.Builder webClientBuilder;

    public AccountDTO getAccount(Long accountId, HttpServletRequest request) {
        return webClientBuilder.build()
                .get()
                .uri(USER_MODULE_URL, accountId)
                .header("Authorization", request.getHeader("Authorization"))
                .retrieve()
                .bodyToMono(AccountDTO.class)
                .block();
    }
}
