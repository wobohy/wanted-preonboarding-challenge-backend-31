package com.wanted.preonboarding_back.domain.product.dto;


import com.wanted.preonboarding_back.domain.brand.dto.BrandResponseDto;
import com.wanted.preonboarding_back.domain.product.enums.ProductStatus;
import com.wanted.preonboarding_back.domain.seller.dto.SellerResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductListResponseDto {

    private Long id;
    private String name;
    private String slug;                            // 상품 고유 URL
    private String short_Description;               // 짧은 설명
    private String base_price;                      // 기본 가격
    private String sale_price;                      // 할인 가격
    private String currency;                        // 화폐 단위
    private ProductImageResponseDto primary_image;  // 대표 이미지
    private BrandResponseDto brand;
    private SellerResponseDto seller;
    private String rating;                           // 평점
    private String review_count;                     // 리뷰 수
    private Boolean in_stock;                        // 재고 유무
    private ProductStatus status;
    private String created_at;
}
