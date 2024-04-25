package org.chronica.group.api.group.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.chronica.group.api.group.enumerated.Category;
import org.chronica.model.ChronicaEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "my_group")
public class Group extends PanacheEntity implements ChronicaEntity {
    private String name;
    private String description;
    private Category category;
    private Long ownerId;
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
