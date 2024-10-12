package org.chronica.library.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class NotificationClient {
    private static final String USER_MODULE_URL = "http://Chronica-notification-module/api/notifications";
    private final WebClient.Builder webClientBuilder;
}
