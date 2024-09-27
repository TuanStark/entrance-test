package com.example.ENTRANCE.TEST.entity;

import com.example.ENTRANCE.TEST.helpper.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role extends BaseEntity {
    private String name;
    private String description;
    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL)
    private Set<User> user = new HashSet<>();
}
