package org.chronica.project.data.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project extends PanacheEntity {
    private String name;
    private Long groupId;
    private LocalDate createdDate;
    private LocalDateTime lastChangeDate;
    private boolean deprecated = false;
}
