package com.wanted.preonboarding_back.domain.product.controller;

import com.wanted.preonboarding_back.domain.product.dto.ProductListResponseDto;
import com.wanted.preonboarding_back.domain.product.dto.ProductRequestDto;
import com.wanted.preonboarding_back.domain.product.service.ProductService;
import com.wanted.preonboarding_back.global.common.api.ApiResponse;
import com.wanted.preonboarding_back.global.common.api.PaginationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    
    @GetMapping
    public ResponseEntity<ApiResponse<PaginationResponse<ProductListResponseDto>>> getProductList(ProductRequestDto requestDto) {
        return ApiResponse.success(productService.getProductList(requestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id) {
        // 특정 상품 조회 로직
        return ResponseEntity.ok().body("특정 상품");
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductRequestDto requestDto) {
        // 상품 생성 로직
        return ResponseEntity.ok().body("상품 생성");
    }
}