package com.nike.nordgym.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private UserDto user;
    private List<ProductDto> products;
}
