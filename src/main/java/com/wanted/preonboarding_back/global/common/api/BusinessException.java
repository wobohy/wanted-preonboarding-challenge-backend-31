package com.wanted.preonboarding_back.global.common.api;

import com.wanted.preonboarding_back.global.common.enums.ErrorCode;
import lombok.Getter;

// 비즈니스 예외 클래스
@Getter
public class BusinessException extends RuntimeException {
    private final ErrorCode errorCode;

    public BusinessException(String message) {
        super(message);
        this.errorCode = ErrorCode.INTERNAL_ERROR;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}