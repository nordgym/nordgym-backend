package com.nike.nordgym.controller;

import com.nike.nordgym.model.ProductDto;
import com.nike.nordgym.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("/{id}")
    public ProductDto getById(@PathVariable(value = "id") Long id) {
        return this.productService.getById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<ProductDto> addProduct(@Valid @RequestBody ProductDto productDto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.productService.save(productDto));
    }

    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductDto> edit(@PathVariable(value = "id") Long id,
                                           @RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productService.update(id, productDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        this.productService.delete(id);
    }
}
