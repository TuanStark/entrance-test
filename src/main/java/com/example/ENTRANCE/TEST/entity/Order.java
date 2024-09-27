package com.example.ENTRANCE.TEST.entity;


import com.example.ENTRANCE.TEST.helpper.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Order extends BaseEntity {
    private int status;
    private String note;
    @Column(name = "order_date")
    private LocalDate orderDate;
    @Column(name = "total_money")
    private double totalMoney;
    @Column(name = "payment_method")
    private int paymentMethods;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<OrderDetail> orderDetail = new HashSet<>();
}
