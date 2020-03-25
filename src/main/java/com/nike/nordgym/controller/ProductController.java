package com.nike.nordgym.controller;

import com.nike.nordgym.model.ProductDto;
import com.nike.nordgym.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/all")
    public List<ProductDto> getAllProducts() {

        return this.productService.getAll();
    }
}
