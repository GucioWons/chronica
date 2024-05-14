package com.chronica.gateway.quarkus;

import jakarta.ws.rs.PathParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping(path = "/api/projects", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ProjectClient {
    private final WebClient.Builder webClientBuilder;
    @Value("${quarkus.project.uri}")
    private String uri;

    public ProjectClient(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @GetMapping(path = "")
    public Mono<List<Object>> getProjects() {
        return webClientBuilder.build()
                .get()
                .uri(uri)
                .retrieve()
                .bodyToFlux(Object.class)
                .collectList();
    }

    @PostMapping(path = "")
    public Mono<Object> createProject(@RequestBody Object project) {
        return webClientBuilder.build()
                .post()
                .uri(uri)
                .body(BodyInserters.fromValue(project))
                .retrieve()
                .bodyToMono(Object.class);
    }

    @GetMapping(path ="/{projectId}")
    public Mono<Object> getProject(@PathParam("projectId") Long projectId) {
        return webClientBuilder.build()
                .get()
                .uri(uri + "/{projectId}", projectId)
                .retrieve()
                .bodyToMono(Object.class);
    }

    @PutMapping(path ="/{projectId}")
    public Mono<Object> updateProject(@PathParam("projectId") Long projectId, @RequestBody Object project) {
        return webClientBuilder.build()
                .put()
                .uri(uri + "/{projectId}", projectId)
                .body(BodyInserters.fromValue(project))
                .retrieve()
                .bodyToMono(Object.class);
    }

    @DeleteMapping(path ="/{projectId}")
    public Mono<Object> deleteProject(@PathParam("projectId") Long projectId) {
        return webClientBuilder.build()
                .delete()
                .uri(uri + "/{projectId}", projectId)
                .retrieve()
                .bodyToMono(Object.class);
    }

    @GetMapping(path = "/group/{groupId}")
    public Mono<Object> getProjectByGroupId(@PathParam("projectId") Long groupId) {
        return webClientBuilder.build()
                .get()
                .uri(uri + "/group/{groupId}", groupId)
                .retrieve()
                .bodyToMono(Object.class);
    }
}
