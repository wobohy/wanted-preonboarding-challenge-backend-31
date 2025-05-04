package com.wanted.preonboarding_back.domain.product.controller;

import com.wanted.preonboarding_back.domain.product.dto.ProductListResponseDto;
import com.wanted.preonboarding_back.domain.product.dto.ProductRequestDto;
import com.wanted.preonboarding_back.domain.product.service.ProductService;
import com.wanted.preonboarding_back.global.common.api.ApiResponse;
import com.wanted.preonboarding_back.global.common.api.PaginationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    
    @GetMapping
    public ResponseEntity<ApiResponse<PaginationResponse<ProductListResponseDto>>> getProductList(@RequestParam(required = false) int page,
                                                                                                  @RequestParam(required = false) int size,
                                                                                                  @RequestParam(required = false) String sort,
                                                                                                @RequestParam(required = false) String status,
                                                                                                @RequestParam(required = false) int minPrice,
                                                                                                @RequestParam(required = false) int maxPrice,
                                                                                                @RequestParam(required = false) int[] category,
                                                                                                @RequestParam(required = false) int seller,
                                                                                                @RequestParam(required = false) int brand,
                                                                                                @RequestParam(required = false) boolean inStock,
                                                                                                @RequestParam(required = false) String search) {

        List<ProductListResponseDto> productList = productService.getProductList();
        return ResponseEntity.ok(ApiResponse.success(new PaginationResponse<>(productList, null)));
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