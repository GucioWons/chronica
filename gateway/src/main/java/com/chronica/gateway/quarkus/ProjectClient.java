package com.chronica.gateway.quarkus;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

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
    public Mono<List<Object>> getProjects() {
        return webClientBuilder.build()
                .get()
                .uri(uri)
                .retrieve()
                .bodyToFlux(Object.class)
                .collectList();
    }

    @PostMapping()
    public Mono<Object> createProject(@RequestBody Object project) {
        return webClientBuilder.build()
                .post()
                .uri(uri)
                .body(BodyInserters.fromValue(project))
                .retrieve()
                .bodyToMono(Object.class);
    }

    @GetMapping("/{projectId}")
    public Mono<Object> getProject(@PathVariable Long projectId) {
        return webClientBuilder.build()
                .get()
                .uri(uri + "/{projectId}", projectId)
                .retrieve()
                .bodyToMono(Object.class);
    }

    @PutMapping("/{projectId}")
    public Mono<Object> updateProject(@PathVariable Long projectId, @RequestBody Object project) {
        return webClientBuilder.build()
                .put()
                .uri(uri + "/{projectId}", projectId)
                .body(BodyInserters.fromValue(project))
                .retrieve()
                .bodyToMono(Object.class);
    }

    @DeleteMapping("/{projectId}")
    public Mono<Object> deleteProject(@PathVariable Long projectId) {
        return webClientBuilder.build()
                .delete()
                .uri(uri + "/{projectId}", projectId)
                .retrieve()
                .bodyToMono(Object.class);
    }

    @GetMapping("/group/{groupId}")
    public Mono<Object> getProjectByGroupId(@PathVariable Long groupId) {
        return webClientBuilder.build()
                .get()
                .uri(uri + "/group/{groupId}", groupId)
                .retrieve()
                .bodyToMono(Object.class);
    }
}
