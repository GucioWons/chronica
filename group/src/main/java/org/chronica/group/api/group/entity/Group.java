package org.chronica.group.api.group.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "my_group")
public class Group extends PanacheEntity {
    private String name;
    private String description;
    private Category category;
    private Long ownerId;
    private boolean deprecated = false;
}
