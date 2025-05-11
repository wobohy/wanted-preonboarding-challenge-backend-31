package com.wanted.preonboarding_back.domain.product.dto;

import com.wanted.preonboarding_back.domain.product.entity.ProductImageEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductImageResponseDto {
    private String url;
    private String alt_text;

    public static ProductImageResponseDto from(ProductImageEntity productImageEntity) {
        return ProductImageResponseDto.builder()
                .url(productImageEntity.getUrl())
                .alt_text(productImageEntity.getAltText())
                .build();
    }
}
