package com.nike.nordgym.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    @DecimalMin(value = "0.01")
    private BigDecimal price;

}
