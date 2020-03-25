package com.nike.nordgym.service;

import com.nike.nordgym.domain.Product;
import com.nike.nordgym.model.ProductDto;
import com.nike.nordgym.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> getAll() {

        return this.productRepository.findAll().stream().map(Product::toDto).collect(Collectors.toList());
    }
}
