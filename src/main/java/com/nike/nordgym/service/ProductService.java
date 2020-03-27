package com.nike.nordgym.service;

import com.nike.nordgym.model.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAll();

    void save(ProductDto productDto);
}
