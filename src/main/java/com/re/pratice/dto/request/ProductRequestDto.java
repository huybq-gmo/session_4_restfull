package com.re.pratice.dto.request;

import lombok.Builder;

@Builder
public record ProductRequestDto(
        String name,
        int quantity,
        String category
) {
}
