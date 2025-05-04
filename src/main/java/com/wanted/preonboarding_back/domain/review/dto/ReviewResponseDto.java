package com.wanted.preonboarding_back.domain.review.dto;

import lombok.Getter;

@Getter
public class ReviewResponseDto {
    private Long id;
    private Long productId;
    private String productName;
    private Long userId;
    private String userName;
    private Integer rating;
    private String title;
    private String content;
    private boolean verifiedPurchase;
    private Integer helpfulVotes;

}
