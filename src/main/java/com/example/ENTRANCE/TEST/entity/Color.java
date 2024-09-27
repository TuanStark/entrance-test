package com.example.ENTRANCE.TEST.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "color")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "color", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Product> product = new HashSet<>();
}
