package com.nike.nordgym.controller;

import com.nike.nordgym.model.ProductDto;
import com.nike.nordgym.service.ProductService;
<<<<<<< HEAD
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
=======
>>>>>>> 61073dc0a48323a3b950f7ef82685474d0946929
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<ProductDto> addProduct(@Valid @RequestBody ProductDto productDto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.productService.save(productDto));
    }
}
