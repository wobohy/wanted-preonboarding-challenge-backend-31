package com.wanted.preonboarding_back.domain.product.enums;

import lombok.Getter;

@Getter
public enum ProductStatus {
    ACTIVE("판매중"),
    INACTIVE("품절"),
    DELETED("삭제");

    private final String status;

    ProductStatus(String status) {
        this.status = status;
    }

}
