package com.chronica.group.repository;

import com.chronica.group.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    Optional<Group> findByIdAndDeprecatedFalse(Long id);

    List<Group> findAllByDeprecatedFalse();
    Set<Group> findAllByDeprecatedFalseAndOwnerId(Long ownerId);
}
