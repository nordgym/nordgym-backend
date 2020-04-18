package com.nike.nordgym.service;

import com.nike.nordgym.model.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAll();

    ProductDto save(ProductDto productDto);

    ProductDto update(Long id, ProductDto productDto);

    ProductDto getById(Long id);

    void delete(Long id);
}
