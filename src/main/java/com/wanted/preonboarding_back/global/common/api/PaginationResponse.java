package com.wanted.preonboarding_back.global.common.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaginationResponse<T> {
    private List<T> items;
    private PageInfo pagination;
}
