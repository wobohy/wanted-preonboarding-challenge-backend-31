package com.wanted.preonboarding_back.domain.product.dto;

import com.wanted.preonboarding_back.global.common.api.PaginationRequest;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Min;
import lombok.Getter;

@Getter
public class ProductRequestDto extends PaginationRequest {
    private String status;
    @Min(0)
    private Integer minPrice;
    @Min(0)
    private Integer maxPrice;
    private int[] category;
    private Integer seller;
    private Integer brand;
    private Boolean inStock;
    private String search;

    // 가격 범위 검증
    @AssertTrue(message = "최대 가격은 최소 가격보다 커야 합니다")
    private boolean isValidPriceRange() {
        if (minPrice == null || maxPrice == null) {
            return true;
        }
        return maxPrice >= minPrice;
    }

}
