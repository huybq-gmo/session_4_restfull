package com.re.pratice.dto.response;

import lombok.Builder;

@Builder
public record ApiResponse<T>(
        String message,
        T data
) {
    public static <T> ApiResponse<T> response(String msg, T data) {
        return ApiResponse.<T>builder()
                .message(msg)
                .data(data)
                .build();
    }
}
