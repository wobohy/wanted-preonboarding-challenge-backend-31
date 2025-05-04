package com.wanted.preonboarding_back.domain.brand.dto;

import lombok.Getter;

@Getter
public class BrandResponseDto {
    private Long id;
    private String name;
    private String slug;
    private String description;
    private String logoUrl;
    private String website;
}