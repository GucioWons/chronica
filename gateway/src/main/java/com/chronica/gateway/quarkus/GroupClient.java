package com.chronica.gateway.quarkus;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class GroupClient {
    private final WebClient.Builder webClientBuilder;
    @Value("${quarkus.group.uri}")
    private String uri;

    public GroupClient(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @GetMapping()
    public Mono<List<Object>> getGroups() {
        return webClientBuilder.build()
                .get()
                .uri(uri)
                .retrieve()
                .bodyToFlux(Object.class)
                .collectList();
    }

    @PostMapping()
    public Mono<Object> createGroup(@RequestBody Object group) {
        return webClientBuilder.build()
                .post()
                .uri(uri)
                .body(BodyInserters.fromValue(group))
                .retrieve()
                .bodyToMono(Object.class);
    }

    @GetMapping("/{groupId}")
    public Mono<Object> getGroup(@PathVariable Long groupId) {
        return webClientBuilder.build()
                .get()
                .uri(uri + "/{groupId}", groupId)
                .retrieve()
                .bodyToMono(Object.class);
    }

    @PutMapping("/{groupId}")
    public Mono<Object> updateGroup(@PathVariable Long groupId, @RequestBody Object group) {
        return webClientBuilder.build()
                .put()
                .uri(uri + "/{groupId}", groupId)
                .body(BodyInserters.fromValue(group))
                .retrieve()
                .bodyToMono(Object.class);
    }

    @DeleteMapping("/{groupId}")
    public Mono<Object> deleteGroup(@PathVariable Long groupId) {
        return webClientBuilder.build()
                .delete()
                .uri(uri + "/{groupId}", groupId)
                .retrieve()
                .bodyToMono(Object.class);
    }
}
