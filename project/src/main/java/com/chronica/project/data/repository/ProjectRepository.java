package com.chronica.project.data.repository;

import com.chronica.project.data.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    Optional<Project> findByIdAndDeprecatedFalse(Long id);

    List<Project> findByGroupIdAndDeprecatedFalse(Long groupId);

    List<Project> findAllByDeprecatedFalse();
}
