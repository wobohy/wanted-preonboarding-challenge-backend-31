package com.wanted.preonboarding_back.domain.product.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ProductOptionResponseDto {
    private Long id;
    private String name;
    private BigDecimal priceAdjustment;
    private int stockQuantity;
}
