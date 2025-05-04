package com.wanted.preonboarding_back.domain.product.service;

import com.wanted.preonboarding_back.domain.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
