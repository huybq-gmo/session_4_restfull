package com.re.pratice.dto.response;

import lombok.Builder;

@Builder
public record ProductResponseDto(
        String name,
        int quantity,
        String category
) {
}
