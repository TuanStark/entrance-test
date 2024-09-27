package com.example.ENTRANCE.TEST.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "style")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Style {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "style", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Product> product = new HashSet<>();
}
