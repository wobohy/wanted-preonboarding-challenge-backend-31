package com.wanted.preonboarding_back.global.common.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageInfo {
    private long totalItems;
    private int totalPages;
    private int currentPage;
    private int perPage;
}