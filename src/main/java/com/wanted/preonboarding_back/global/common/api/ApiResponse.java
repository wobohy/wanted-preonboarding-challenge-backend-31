package com.wanted.preonboarding_back.global.common.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private boolean success;
    private T data;
    private String message;
    private ErrorResponse error;

    public static <T> ResponseEntity<ApiResponse<T>> success(T data) {
//        return new ApiResponse<>(true, data, "요청이 성공적으로 처리되었습니다.", null);
        return toResponseEntity(data);
    }

    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>(true, data, message, null);
    }

    public static <T> ApiResponse<T> error(ErrorResponse error) {
        return new ApiResponse<>(false, null, null, error);
    }

    public static <T> ResponseEntity<ApiResponse<T>> toResponseEntity(T data) {
        ApiResponse<T> apiResponse = new ApiResponse<>(true, data, null, null);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(apiResponse);
//        if (success) {
//        } else {
//            return ResponseEntity.status(error.getStatus()).body(this);
//        }
    }
}
