package com.wanted.preonboarding_back.domain.product.dto;

import lombok.Getter;

@Getter
public class ProductImageResponseDto {
    private Long id;
    private String imageUrl;
    private int displayOrder;
    private boolean isMainImage;
}
