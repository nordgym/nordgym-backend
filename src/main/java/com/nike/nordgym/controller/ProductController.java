package com.nike.nordgym.controller;

import com.nike.nordgym.model.ProductDto;
import com.nike.nordgym.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<ProductDto> getAllProducts() {

       return this.productService.getAll();
    }

    @PostMapping("/save")
    public void addProduct(@RequestBody ProductDto productDto) {
<<<<<<< HEAD
        this.productService.save(productDto);
=======

        productService.save(productDto);
>>>>>>> 609acd47c8a113a31eb02c98aab6e631300fc2be
    }
}
