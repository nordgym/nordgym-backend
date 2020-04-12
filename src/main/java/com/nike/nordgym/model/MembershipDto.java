package com.nike.nordgym.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
public class MembershipDto {

    private Long id;
    private String name;
    private Integer passes;
    private BigDecimal price;
    private Instant startDate;
    private Instant endDate;
}
