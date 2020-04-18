package com.nike.nordgym.service;

import com.nike.nordgym.domain.Product;
import com.nike.nordgym.model.ProductDto;
import com.nike.nordgym.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductDto> getAll() {

        return this.productRepository.findAll().stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getById(Long id) {
        return modelMapper.map(this.productRepository.getProductById(id), ProductDto.class);
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        return modelMapper.map(productRepository.save(product), ProductDto.class);
    }

    @Override
    public ProductDto update(Long id, ProductDto productDto) {
        if (productRepository.findById(id).isPresent()){
            Product existingProduct = productRepository.findById(id).get();

            existingProduct.setName(productDto.getName());
            existingProduct.setPrice(productDto.getPrice());

            Product updatedProduct = productRepository.save(existingProduct);

            return new ProductDto(updatedProduct.getId(), updatedProduct.getName(), updatedProduct.getPrice());
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
