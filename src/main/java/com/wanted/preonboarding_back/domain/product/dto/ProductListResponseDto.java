package com.wanted.preonboarding_back.domain.product.dto;


import com.wanted.preonboarding_back.domain.brand.dto.BrandResponseDto;
import com.wanted.preonboarding_back.domain.product.entity.ProductEntity;
import com.wanted.preonboarding_back.domain.product.enums.ProductStatus;
import com.wanted.preonboarding_back.domain.review.entity.ReviewEntity;
import com.wanted.preonboarding_back.domain.seller.dto.SellerResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductListResponseDto {

    private Long id;
    private String name;
    private String slug;                            // 상품 고유 URL
    private String short_Description;               // 짧은 설명
    private BigDecimal base_price;                      // 기본 가격
    private BigDecimal sale_price;                      // 할인 가격
    private String currency;                        // 화폐 단위
    private ProductImageResponseDto primary_image;  // 대표 이미지
    private BrandResponseDto brand;
    private SellerResponseDto seller;
    private Double rating;                           // 평점
    private String review_count;                     // 리뷰 수
    private Boolean in_stock;                        // 재고 유무
    private ProductStatus status;
    private String created_at;

    public static List<ProductListResponseDto> convertToListResponse(List<ProductEntity> content) {
        return content.stream()
                .map(productEntity -> ProductListResponseDto.builder()
                        .id(productEntity.getId())
                        .name(productEntity.getName())
                        .slug(productEntity.getSlug())
                        .short_Description(productEntity.getShortDescription())
                        .base_price(productEntity.getProductPriceEntity().getBasePrice())
                        .sale_price(productEntity.getProductPriceEntity().getSalePrice())
                        .currency(productEntity.getProductPriceEntity().getCurrency())
                        .primary_image(ProductImageResponseDto.from(productEntity.getProductImageEntities().get(0)))
                        .brand(BrandResponseDto.from(productEntity.getBrandEntity()))
                        .seller(SellerResponseDto.from(productEntity.getSellerEntity()))
                        .rating(productEntity.getReviewEntities().stream().mapToDouble(ReviewEntity::getRating).average().orElse(0.0))
                        .review_count(String.valueOf(productEntity.getReviewEntities().size()))
                        .in_stock(productEntity.getProductOptionGroupEntities().stream()
                                .anyMatch(optionGroup -> optionGroup.getProductOptionEntities().stream()
                                        .anyMatch(option -> option.getStock() > 0)))
                        .status(productEntity.getStatus())
                        .created_at(productEntity.getCreatedAt().toString())
                        .build())
                .toList();
    }
}
