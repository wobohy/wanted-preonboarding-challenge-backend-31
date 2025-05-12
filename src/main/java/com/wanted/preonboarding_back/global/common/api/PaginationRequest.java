package com.wanted.preonboarding_back.global.common.api;

import lombok.Getter;

@Getter
public class PaginationRequest {
    private int page = 0;
    
    private int perPage = 10;

    private String sort = "created_at:desc";
    
    public int getOffset() {
        return page * perPage;
    }
}