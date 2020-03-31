package com.nike.nordgym.model;

import com.nike.nordgym.constant.Constants;
import lombok.Data;
import lombok.NoArgsConstructor;


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
    @NotBlank
    @Pattern(regexp = "^[0-9]+(\\.[0-9]{1,2})?$", message = Constants.PRODUCT_PRICE_ERROR_MESSAGE)
    private BigDecimal price;

    public ProductDto(Long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
