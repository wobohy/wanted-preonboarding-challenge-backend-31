package com.wanted.preonboarding_back.global.common.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PageInfo {
    private long totalItems;
    private int totalPages;
    private int currentPage;
    private int perPage;
}