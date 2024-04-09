package org.chronica.project.data.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.chronica.project.data.entity.Project;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProjectRepository implements PanacheRepository<Project> {
    public Optional<Project> findByIdNotDeprecated(Long id) {
        return findByIdOptional(id)
                .filter(project -> !project.isDeprecated());
    }

    public List<Project> findByGroupId(Long groupId){
        List<Project> groupProjects = list("groupId", groupId);
        return groupProjects.stream()
                .filter(g -> !g.isDeprecated())
                .toList();
    }
    public List<Project> listAllNotDeprecated() {
        return list("deprecated", false);
    }
}
