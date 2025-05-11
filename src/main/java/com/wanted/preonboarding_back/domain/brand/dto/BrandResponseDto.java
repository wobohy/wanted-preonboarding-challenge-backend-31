package com.wanted.preonboarding_back.domain.brand.dto;

import com.wanted.preonboarding_back.domain.brand.entity.BrandEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BrandResponseDto {
    private Long id;
    private String name;

    public static BrandResponseDto from(BrandEntity brandEntity) {
        return BrandResponseDto.builder()
                .id(brandEntity.getId())
                .name(brandEntity.getName())
                .build();
    }
}