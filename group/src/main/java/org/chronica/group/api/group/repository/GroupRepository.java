package org.chronica.group.api.group.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.chronica.group.api.group.entity.Group;

@ApplicationScoped
public class GroupRepository implements PanacheRepository<Group> {
}
