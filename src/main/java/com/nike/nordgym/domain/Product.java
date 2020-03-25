package com.nike.nordgym.domain;

import com.nike.nordgym.common.DtoConvertable;
import com.nike.nordgym.model.ProductDto;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "products")
public class Product implements DtoConvertable<ProductDto> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    @DecimalMin(value = "0.01")
    private BigDecimal price;

    @Override
    public ProductDto toDto() {
        return new ProductDto(id, name, price);
    }
}
