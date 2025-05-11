package com.wanted.preonboarding_back.domain.product.service;

import com.wanted.preonboarding_back.domain.product.dto.ProductListResponseDto;
import com.wanted.preonboarding_back.domain.product.dto.ProductRequestDto;
import com.wanted.preonboarding_back.global.common.api.PaginationResponse;

public interface ProductService {
    public PaginationResponse<ProductListResponseDto> getProductList(ProductRequestDto requestDto);
}