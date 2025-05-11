package com.wanted.preonboarding_back.domain.seller.dto;

import com.wanted.preonboarding_back.domain.seller.entity.SellerEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SellerResponseDto {
    private Long id;
    private String name;

    public static SellerResponseDto from(SellerEntity sellerEntity) {
        return SellerResponseDto.builder()
                .id(sellerEntity.getId())
                .name(sellerEntity.getName())
                .build();
    }
}
