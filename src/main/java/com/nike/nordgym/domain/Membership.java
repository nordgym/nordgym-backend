package com.nike.nordgym.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data
@Entity
@Table(name = "memberships")
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column
    private Integer passes;

    @Column(nullable = false)
    @DecimalMin(value = "0.01")
    private BigDecimal price;

    @Column
    private Instant startDate;

    @Column
    private Instant endDate;

    @ManyToMany(targetEntity = Order.class, mappedBy = "memberships")
    private List<Order> orders;
}
