package com.nike.nordgym.model;

import com.nike.nordgym.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private User user;
    private List<ProductDto> products;
}
