package com.wanted.preonboarding_back.domain.seller.dto;

import lombok.Getter;

@Getter
public class SellerResponseDto {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String businessNumber;
    private String description;
}
