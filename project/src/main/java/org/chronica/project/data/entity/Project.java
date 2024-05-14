package org.chronica.project.data.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.chronica.model.ChronicaEntity;


import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project extends PanacheEntity implements ChronicaEntity {
    private String name;
    private Long groupId;
    private LocalDate createdDate;
    private LocalDateTime lastChangeDate;
    private boolean deprecated = false;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
