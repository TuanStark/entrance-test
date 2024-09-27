package com.example.ENTRANCE.TEST.helpper.base.model;

import com.example.ENTRANCE.TEST.helpper.base.constant.time.DateGenerator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @JsonSerialize(using = DateGenerator.class)
    @CreationTimestamp
    @Column(name = "CreatedAt")
    private Date createdAt;

    @JsonSerialize(using = DateGenerator.class)
    @UpdateTimestamp
    @Column(name = "UpdatedAt")
    private Date updatedAt;
}
