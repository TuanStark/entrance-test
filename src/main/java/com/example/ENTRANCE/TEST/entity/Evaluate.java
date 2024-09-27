package com.example.ENTRANCE.TEST.entity;

import com.example.ENTRANCE.TEST.helpper.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "evaluate")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evaluate extends BaseEntity {
    private int ratting;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
