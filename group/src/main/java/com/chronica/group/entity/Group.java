package com.chronica.group.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.chronica.library.group.enumerated.Category;
import org.chronica.library.model.ChronicaEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "my_group")
public class Group implements ChronicaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
