package org.chronica.group.api.group.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.chronica.group.api.group.entity.Group;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class GroupRepository implements PanacheRepository<Group> {
    public Optional<Group> findByIdNotDeprecated(Long id) {
        return findByIdOptional(id)
                .filter(group -> !group.isDeprecated());
    }

    public List<Group> listAllNotDeprecated() {
        return list("deprecated", false);
    }
}
