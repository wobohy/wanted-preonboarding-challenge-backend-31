package com.wanted.preonboarding_back.domain.product.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ProductDetailResponseDto {
    private Long id;
    private BigDecimal basePrice;
    private BigDecimal discountedPrice;
    private int stockQuantity;
    private boolean isActive;
}
