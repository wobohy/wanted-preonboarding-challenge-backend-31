package com.wanted.preonboarding_back.domain.product.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ProductStatus {
    ACTIVE("판매중"),
    INACTIVE("품절"),
    DELETED("삭제");

    private static final Map<String, String> CODE_MAP = Collections.unmodifiableMap(Stream.of(values()).collect(Collectors.toMap(ProductStatus::getStatus, ProductStatus::name)));

    @Getter
    private final String status;

    ProductStatus(String status) {
        this.status = status;
    }

    public static ProductStatus of(final String status) {
        return valueOf(CODE_MAP.get(status));
    }

    @JsonCreator
    public static ProductStatus from(final String status) {
        return ProductStatus.of(status);
    }

}
