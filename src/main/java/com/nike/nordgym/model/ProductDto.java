package com.nike.nordgym.model;

import lombok.Data;


import java.math.BigDecimal;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private BigDecimal price;

    public ProductDto(Long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
