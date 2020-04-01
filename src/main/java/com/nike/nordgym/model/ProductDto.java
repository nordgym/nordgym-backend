package com.nike.nordgym.model;

import com.nike.nordgym.constant.Constants;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProductDto {

    private Long id;

    @NotBlank
    @Pattern(regexp = "^[A-Za-z ]{2,50}", message = Constants.PRODUCT_NAME_ERROR_MESSAGE)
    private String name;

    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 4, fraction = 2)
    private BigDecimal price;

    public ProductDto(Long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
