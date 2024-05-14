package com.chronica.gateway.quarkus;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/projects")
public class ProjectClient {
    private final WebClient.Builder webClientBuilder;
    @Value("${quarkus.project.uri}")
    private String uri;

    public ProjectClient(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @GetMapping()
    public Mono<Object> getProjects() {
        return webClientBuilder.build()
                .get()
                .uri(uri)
                .retrieve()
                .bodyToMono(Object.class);
    }

    @PostMapping()
    public Mono<Object> createProject() {
        return webClientBuilder.build()
                .get()
                .uri(uri)
                .retrieve()
                .bodyToMono(Object.class);
    }

    @GetMapping("/{projectId}")
    public Mono<Object> getProject(@PathVariable String projectId) {
        return webClientBuilder.build()
                .get()
                .uri(uri + "/{projectId}")
                .retrieve()
                .bodyToMono(Object.class);
    }

    @PutMapping("/{projectId}")
    public Mono<Object> updateProject(@PathVariable String projectId) {
        return webClientBuilder.build()
                .get()
                .uri(uri + "/{projectId}")
                .retrieve()
                .bodyToMono(Object.class);
    }

    @DeleteMapping("/{projectId}")
    public Mono<Object> deleteProject(@PathVariable Long projectId) {
        return webClientBuilder.build()
                .get()
                .uri(uri + "/{projectId}")
                .retrieve()
                .bodyToMono(Object.class);
    }

    @GetMapping("/group/{groupId}")
    public Mono<Object> getProjectByGroupId(@PathVariable Long groupId) {
        return webClientBuilder.build()
                .get()
                .uri(uri + "/group/{groupId}")
                .retrieve()
                .bodyToMono(Object.class);
    }
}
